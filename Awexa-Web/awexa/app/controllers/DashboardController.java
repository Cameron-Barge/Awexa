package controllers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import model.*;
import model.Query;
import play.api.libs.json.Json;
import play.api.libs.json.Writes;
import play.data.Form;
import play.data.FormFactory;


import play.mvc.*;
import javax.inject.*;
import java.io.FileInputStream;
import java.util.*;


import static play.mvc.Controller.session;
import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;



public class DashboardController {
	@Inject FormFactory formFactory;

    public Result postLogin() {
        if(session("connected") == null)
            return redirect(routes.HomeController.index());

        System.out.println("test");
        return ok(views.html.postlogin.render(session("connected"), getParents(), getChildren()));
    }

    public Result addParent() {
        if(session("connected") == null)
            return redirect(routes.HomeController.index());


        return ok(views.html.newparent.render(""));
    }

    public Result parentRequest() {
        if(session("connected") == null)
            return redirect(routes.HomeController.index());


        return ok(views.html.parentauth.render());
    }

    public Result parentView() {
        if(session("connected") == null)
            return redirect(routes.HomeController.index());


        return ok(views.html.parentview.render());
    }

    public Result childView() {
        if(session("connected") == null)
            return redirect(routes.HomeController.index());


        return ok(views.html.childview.render());
    }

    public Result parentAuth(){
        if(session("connected") == null)
            return redirect(routes.HomeController.index());

        getParents();
        return ok(views.html.parentview.render());
    }

    public Result addChore() {
        if(session("connected") == null)
            return redirect(routes.HomeController.index());


        return ok(views.html.addchore.render());
    }

    public Result addReward() {
        if(session("connected") == null)
            return redirect(routes.HomeController.index());


        return ok(views.html.addreward.render());
    }
		
		/**
		 * saves newly registered account data to database
		 * @return Result location to return to
		 */
		public Result saveNewData() {
			Form<Child> newDataForm = formFactory.form(Child.class).bindFromRequest();
			Map<String, String> data = newDataForm.rawData();
			Child child = new Child(data.get("childName"), Global.family.getUsername());
			Parent parent = new Parent(data.get("parentFirstName"), data.get("parentLastName"), Global.family.getUsername());
			String childKey = FirebaseServices.pushNode("children/", child);
			child.setID(childKey);
			String parentKey = FirebaseServices.pushNode("parents/", parent);
			parent.setID(parentKey);
			Global.family.addChild(child);
			Global.family.addParent(parent);
			FirebaseServices.update(Global.family);
			return ok(views.html.postlogin.render(parent.getName(),getParents(), getChildren()));
		}


    public List<String> getParents() {
        FirebaseServices.updateSnapshot("families/" + session("connected"));
        List<String> parentNames = new ArrayList<String>();
        HashMap<String, Boolean> fam = (HashMap<String, Boolean>) Global.curRef.child("parents").getValue();
        Set<String> parents = fam.keySet();
        //System.out.println(Global.curRef);
        //System.out.println(parents);
        FirebaseServices.updateSnapshot("parents/");

        for(String p : parents) {
            //System.out.println(p);
            //System.out.println(Global.curRef);
            parentNames.add((String) Global.curRef.child(p).child("name").getValue());
        }

        //System.out.println(parentNames);

        return parentNames;
    }
    public List<String> getChildren() {
        FirebaseServices.updateSnapshot("families/" + session("connected"));
        List<String> childNames = new ArrayList<String>();
        HashMap<String, Boolean> fam = (HashMap<String, Boolean>) Global.curRef.child("children").getValue();
        Set<String> kids = fam.keySet();
        //System.out.println(Global.curRef);
        //System.out.println(parents);
        FirebaseServices.updateSnapshot("children/");

        for(String p : kids) {
            //System.out.println(p);
            //System.out.println(Global.curRef);
            childNames.add((String) Global.curRef.child(p).child("name").getValue());
        }

        //System.out.println(parentNames);

        return childNames;
    }

		public Result submitReward() {
			Form<Reward> newRewardForm = formFactory.form(Reward.class).bindFromRequest();
			Map<String, String> data = newRewardForm.rawData();
			Reward reward = new Reward(data.get("description"), data.get("name"), Integer.parseInt(data.get("points")));
			String rewardKey = FirebaseServices.pushNode("rewards/", reward);
			reward.setID(rewardKey);
			Global.family.addReward(reward);
			FirebaseServices.update(Global.family);
			return ok(views.html.postlogin.render(session("connected"),getParents(), getChildren()));
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
			return ok(views.html.postlogin.render(session("connected"), getParents(), getChildren()));
		}

}