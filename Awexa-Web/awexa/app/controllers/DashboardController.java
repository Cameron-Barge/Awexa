package controllers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import model.*;
import play.data.Form;
import play.data.FormFactory;

import play.mvc.*;
import javax.inject.*;
import java.io.FileInputStream;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import static play.mvc.Controller.session;
import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;

public class DashboardController {
    @Inject
    FormFactory formFactory;

    public Result postLogin() {
        if (session("connected") == null)
            return redirect(routes.HomeController.index());

        return ok(views.html.postlogin.render(session("connected")));
    }

    public Result addParent() {
        if (session("connected") == null)
            return redirect(routes.HomeController.index());

        return ok(views.html.newparent.render(""));
    }

    public Result parentRequest() {
        if (session("connected") == null)
            return redirect(routes.HomeController.index());

        return ok(views.html.parentauth.render());
    }

    public Result parentView() {
        if (session("connected") == null) {
            return redirect(routes.HomeController.index());
        } else {
            ArrayList<Chore> chores = FirebaseServices.getChoresFromDB();
            ArrayList<Reward> rewards = FirebaseServices.getRewardsFromDB();
            for (Chore chore : chores) {
                System.out.println("Chore name:" + chore.toString());
            }
            return ok(views.html.parentview.render(chores, rewards));
        }
    }

    public Result childView() {
        if (session("connected") == null)
            return redirect(routes.HomeController.index());

        return ok(views.html.childview.render());
    }

    public Result parentAuth() {
        ArrayList<Chore> chores = FirebaseServices.getChoresFromDB();
        ArrayList<Reward> rewards = FirebaseServices.getRewardsFromDB();
        for (Reward reward : rewards) {
            System.out.println("Chore name:" + reward.getName());
        }
        return ok(views.html.parentview.render(chores, rewards));
    }

    public Result addChore() {
        if (session("connected") == null)
            return redirect(routes.HomeController.index());

        return ok(views.html.addchore.render());
    }

    public Result addReward() {
        if (session("connected") == null)
            return redirect(routes.HomeController.index());

        return ok(views.html.addreward.render());
    }

    public Result saveNewData() {
        Form<Child> newDataForm = formFactory.form(Child.class).bindFromRequest();
        Map<String, String> data = newDataForm.rawData();
        Child child = new Child(data.get("childName"), Global.family.getFamilyName());
        Parent parent = new Parent(data.get("parentFirstName"), data.get("parentLastName"));
        String familyKey = Global.family.getID();
        String childKey = FirebaseServices.pushNode("children/", child);
        child.setID(childKey);
        String parentKey = FirebaseServices.pushNode("parents/", parent);
        parent.setID(parentKey);
        Global.family.addChild(child);
        Global.family.addParent(parent);
        FirebaseServices.update(Global.family);
        return ok(views.html.postlogin.render(data.get("parentName")));
    }

    public Result submitReward() {
        Form<Reward> newRewardForm = formFactory.form(Reward.class).bindFromRequest();
        Map<String, String> data = newRewardForm.rawData();
        Reward reward = new Reward(data.get("description"), data.get("name"), Integer.parseInt(data.get("points")));
        String rewardKey = FirebaseServices.pushNode("rewards/", reward);
        reward.setID(rewardKey);
        Global.family.addReward(reward);
        FirebaseServices.update(Global.family);
        return ok(views.html.postlogin.render(session("connected")));
    }

    public Result submitChore() {
        // pull form data into chore class map 
        Form<Chore> newChoreForm = formFactory.form(Chore.class).bindFromRequest();
        Map<String, String> data = newChoreForm.rawData();
        // get data objects from data map
        String name = data.get("name");
        String description = data.get("description");
        int points = Integer.parseInt(data.get("points"));
        String starttime = data.get("starttime");
        String endtime = data.get("endtime");
        // generate weekly recurrence map
        Map<String, String> weekly = new HashMap<String, String>();
        int dayCount = 0;
        for (String day : Recurrence.getWeek()) {
            String check = data.get(day);
            if (check.equals("true")) {
                dayCount++;
            }
            weekly.put(day, check);
        }
        // determine if weekly or daily recurrence
        String repeat = (dayCount == 7) ? "daily" : "weekly";
        // create respective recurrence and chore objects from form parameters
        Recurrence recurrence = new Recurrence(starttime, endtime, repeat, weekly);
        Chore chore = new Chore(name, description, points, recurrence);
        // add chore object to firebase
        String choreKey = FirebaseServices.pushNode("chores/", chore);
        chore.setID(choreKey);
        // update global family object with new chore and update to database
        Global.family.addChore(chore);
        FirebaseServices.update(Global.family);
        return ok(views.html.postlogin.render(session("connected")));
    }
}