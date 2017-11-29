package controllers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
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
    @Inject
    FormFactory formFactory;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private String familyRef = "";

    public Result login() {
        System.out.println("?");

        Global.waiting = true;

        Form<Login> loginForm = formFactory.form(Login.class).bindFromRequest();
        Map<String, String> data = loginForm.rawData();
        Global.familyName = data.get("user");
        Global.loginUser = data.get("user");
        Global.id = data.get("user");
        Global.loginPass = data.get("pass");
        Family family = new Family(data.get("user"), data.get("pass"));
        Global.family = family;

        System.out.println("1");
        FirebaseServices.updateSnapshot("families/" + Global.familyName);
        System.out.println("2");

        if (Global.curRef != null) {
            //System.out.println(Global.loginPass + " " + Global.curRef.child("familyPass").getValue());
            if (Global.loginPass.equals(Global.curRef.child("familyPass").getValue())) {
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
        if (Global.auth) {
            Global.auth = false;
            session("connected", Global.familyName);
            return redirect(routes.DashboardController.postLogin());
        } else {
            session().clear();
            return ok(views.html.login.render("Login", "Incorrect Login", false));
        }
    }

    public void updateName(String name) {
        System.out.println("updated name");
        familyRef = name;
    }

    public Result getLogin() {
        if (session("connected") != null)
            return redirect(routes.DashboardController.postLogin());

        return ok(views.html.login.render("Login", "", false));

    }

    public Result getRegistration() {
        if (session("connected") != null)
            return redirect(routes.DashboardController.postLogin());

        return ok(views.html.register.render("Register", "", session("connected") != null));
    }

    public Result logout() {
        Global.reset();
        session().clear();
        return redirect(routes.HomeController.index());
    }

    public Result register() {
        Form<Registration> loginForm = formFactory.form(Registration.class).bindFromRequest();
        Map<String, String> data = loginForm.rawData();
        
        if (!data.get("pass").equals(data.get("pass2"))) {
            return ok(views.html.register.render("Register", "Passwords do not match", session("connected") != null));
        } else {
            String email = data.get("user");
            String password = data.get("pass");
            Family family = new Family(data.get("user"), data.get("pass"));
            FirebaseServices.createUser(email, password);
            Global.family = family;
            
            Global.id = data.get("user");
            Global.family.setID(data.get("user"));
            return ok(views.html.newparent.render("Let's get your account set up!"));
        }
    }

}
