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
			Form<Registration> newDataForm = formFactory.form(Registration.class).bindFromRequest();
			Map<String, String> data = newDataForm.rawData();
			
			Global.familyName = data.get("user");
			FirebaseServices.updateSnapshot("families/" + Global.familyName);
			return ok(views.html.postlogin.render(Global.familyName));
		}
}