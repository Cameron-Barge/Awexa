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
        Global.username = data.get("user");
        Global.loginUser = data.get("user");
        Global.loginPass = data.get("pass");

        System.out.println("1");
        FirebaseServices.updateSnapshot("families/" + Global.username);
        System.out.println("2");

        if(Global.curRef.getValue() != null) {
            //System.out.println(Global.loginPass + " " + Global.curRef.child("familyPass").getValue());
            if(Global.loginPass.equals(Global.curRef.child("familyPass").getValue())){
								Global.family = new Family(Global.username, Global.loginPass);
                Global.auth = true;
            } else {
                Global.auth = false;
            }
        } else {
            Global.auth = false;
        }


        System.out.println("Authenticated: " + Global.auth);

        // Login Authenticated
        Global.username = Global.loginUser;
        Global.loginUser = "";
        Global.loginPass = "";
        if(Global.auth) {
            Global.auth = false;
            session("connected", Global.username);
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

        return ok(views.html.register.render("Register","", session("connected") != null));
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
            return ok(views.html.register.render("Register","Passwords do not match", session("connected") != null));


				Global.username = data.get("user");
				DatabaseReference familyRef = database.getReference("families");
				familyRef.setValue(Global.username);
        FirebaseServices.updateSnapshot("families/" + Global.username);


        if(Global.curRef.getValue() != null) {
            Global.username = "";
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
				Family family = new Family(data.get("user"), data.get("pass"));
				FirebaseServices.createNode("/families", data.get("user"), family);
				Global.family = family;
				session("connected", data.get("user"));
				return ok(views.html.newparent.render("Let's get your account set up!"));

			}
            
		}

}
