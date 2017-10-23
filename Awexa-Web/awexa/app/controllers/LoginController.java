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
        FirebaseServices.updateSnapshot();
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
            return redirect(routes.DashboardController.postLogin());
        }
        else
            return ok(views.html.login.render("Login","Incorrect Login"));
    }

    public void updateName(String name){
        System.out.println("updated name");
        familyRef = name;
    }

    public Result getLogin() {
        return ok(views.html.login.render("Login",""));
    }

    public Result getRegistration() {
        return ok(views.html.register.render("Register",""));
    }

    public Result logout() {
        Global.reset();
        return redirect(routes.HomeController.index());
    }

    public Result register() {

        Form<Registration> loginForm = formFactory.form(Registration.class).bindFromRequest();
        Map<String, String> data = loginForm.rawData();

        System.out.println(data.get("user"));
        System.out.println(data.get("pass"));
        System.out.println(data.get("pass2"));

        if(!data.get("pass").equals(data.get("pass2")))
            return ok(views.html.register.render("Register","Passwords do not match"));

        Global.familyName = data.get("user");
        FirebaseServices.updateSnapshot();

        if(Global.curRef.getValue() != null) {
            Global.familyName = "";
            return ok(views.html.register.render("Register","Family Name already exists"));
        }


        return ok(views.html.newparent.render("Let's get your account set up!"));
    }

}
