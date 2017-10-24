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

import static play.mvc.Controller.session;
import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;


public class DashboardController {
	@Inject FormFactory formFactory;

    public Result postLogin() {
        if(session("connected") == null)
            return redirect(routes.HomeController.index());


        return ok(views.html.postlogin.render(session("connected")));
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
			Child child = new Child(data.get("childName"), Global.family.getID());
			Parent parent = new Parent(data.get("parentName"), Global.family.familyPass, Global.family.getID());
			String childKey = FirebaseServices.pushNode("children/", child);
			String parentKey = FirebaseServices.pushNode("parents/", parent);
			/*
			String childKey = FirebaseServices.addNode("families/" + Global.family.getID() + "/children/", child);
			String parentKey = FirebaseServices.addNode("families/" + Global.family.getID() + "/parents/", parent);
			*/
			Global.family.addChild(child);
			Global.family.addParent(parent);
			FirebaseServices.update(Global.family);
			return ok(views.html.postlogin.render(data.get("childName")));
		}
}