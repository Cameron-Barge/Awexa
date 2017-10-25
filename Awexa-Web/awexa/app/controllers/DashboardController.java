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
        return ok(views.html.postlogin.render(session("connected"), getParents()));
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
			return ok(views.html.postlogin.render(parent.getName(),null));
		}

    public List<String> getParents() {
        FirebaseServices.updateSnapshot("families/" + session("connected"));
        List<String> parentNames = new ArrayList<String>();
        HashMap<String, Boolean> fam = (HashMap<String, Boolean>) Global.curRef.child("parents").getValue();
        Set<String> parents = fam.keySet();
        System.out.println(Global.curRef);
        System.out.println(parents);
        FirebaseServices.updateSnapshot("parents/");

        for(String p : parents) {
            System.out.println(p);
            System.out.println(Global.curRef);
            parentNames.add((String) Global.curRef.child(p).child("name").getValue());
        }

        System.out.println(parentNames);

        return parentNames;
    }
}