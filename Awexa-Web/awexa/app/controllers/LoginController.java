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


public class LoginController {
    @Inject FormFactory formFactory;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private String familyRef = "";


    public Result login() {
        System.out.println("?");

        Global.waiting = true;

        Form<Login> loginForm = formFactory.form(Login.class).bindFromRequest();
        Map<String, String> data = loginForm.rawData();
        Global.familyName = data.get("user");
        Global.loginUser = data.get("user");
        Global.loginPass = data.get("pass");

        System.out.println("1");
        FirebaseServices.updateSnapshot("families/" + Global.familyName);
        System.out.println("2");

        if(Global.curRef.getValue() != null) {
            //System.out.println(Global.loginPass + " " + Global.curRef.child("familyPass").getValue());
            if(Global.loginPass.equals(Global.curRef.child("familyPass").getValue())){
                Global.auth = true;
            } else {
                Global.auth = false;
            }
        } else {
            Global.auth = false;
        }


        System.out.println("Authenticated: " + Global.auth);

        // Login Authenticated
        Global.familyName = Global.loginUser;
        Global.loginUser = "";
        Global.loginPass = "";
        if(Global.auth) {
            Global.auth = false;
            session("connected", Global.familyName);
            return redirect(routes.DashboardController.postLogin());
        }
        else {
            session().clear();
            return ok(views.html.login.render("Login", "Incorrect Login", false));
        }
    }


    public void updateName(String name){
        System.out.println("updated name");
        familyRef = name;
    }

    public Result getLogin() {
        if(session("connected") != null)
            return redirect(routes.DashboardController.postLogin());

        return ok(views.html.login.render("Login","", false));

    }


    public Result getRegistration() {
        if(session("connected") != null)
            return redirect(routes.DashboardController.postLogin());

        return ok(views.html.register.render("Register","", session("connected")!=null));
    }

    public Result logout() {
        Global.reset();
        session().clear();
        return redirect(routes.HomeController.index());
    }

    public Result register2() {

        Form<Registration> loginForm = formFactory.form(Registration.class).bindFromRequest();
        Map<String, String> data = loginForm.rawData();
				/*
        System.out.println(data.get("user"));
        System.out.println(data.get("pass"));
				System.out.println(data.get("pass2"));
				*/

        if(!data.get("pass").equals(data.get("pass2")))
            return ok(views.html.register.render("Register","Passwords do not match", session("connected")!=null));


				Global.familyName = data.get("user");
				DatabaseReference familyRef = database.getReference("families");
				familyRef.setValue(Global.familyName);
        FirebaseServices.updateSnapshot("families/" + Global.familyName);


        if(Global.curRef.getValue() != null) {
            Global.familyName = "";
            return ok(views.html.register.render("Register","Family Name already exists",session("connected") != null));
        }

				Global.auth = true;
        return ok(views.html.newparent.render("Let's get your account set up!"));
		}
		
		public Result register() {
			Form<Registration> loginForm = formFactory.form(Registration.class).bindFromRequest();
			Map<String, String> data = loginForm.rawData();

			if(!data.get("pass").equals(data.get("pass2"))) {
				return ok(views.html.register.render("Register","Passwords do not match", session("connected") != null));
			} else {
				Global.family = new Family(data.get("user"), data.get("pass"));
				FirebaseServices.addNode("/families", Global.family);
				return ok(views.html.newparent.render("Let's get your account set up!"));
			}
		}

}
