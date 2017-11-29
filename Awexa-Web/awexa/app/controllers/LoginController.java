package controllers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.*;
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

        Form<Login> loginForm = formFactory.form(Login.class).bindFromRequest();
        Map<String, String> data = loginForm.rawData();
        String email = data.get("email");
        String pass = data.get("pass");

        FirebaseServices.login(email, pass);

        if (Global.auth) {
            Global.auth = false;
            session("connected");
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
            String email = data.get("email");
            String password = data.get("pass");
            String uid = FirebaseServices.createUser(email, password);
            Family family = new Family(uid, password);
            Global.family = family;
            Global.id = uid;
            Global.email = email;
            Global.family.setID(uid);
            FirebaseServices.update(family);
            return ok(views.html.newparent.render("Let's get your account set up!"));
        }
    }

}
