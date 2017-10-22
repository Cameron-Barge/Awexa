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

        /*Global.waiting = true;

        Form<Login> loginForm = formFactory.form(Login.class).bindFromRequest();
        Map<String, String> data = loginForm.rawData();

        String path = "families/" + data.get("user");
        DatabaseReference ref = database.getReference(path);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println(dataSnapshot);
                if(dataSnapshot.getValue() != null) {
                    System.out.println(data.get("pass") + " " + dataSnapshot.child("familyPass").getValue());
                    if(data.get("pass").equals(dataSnapshot.child("familyPass").getValue())){
                        //session("connected",data.get("user"));
                        updateName(data.get("user"));
                    }
                } else {
                    System.out.println("Incorrect Login");
                    Global.waiting = false;
                }

                Global.waiting = false;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        while(Global.waiting){
            System.out.print(".");
            int count = 0;
            count++;
            if(count%10 == 0)
                System.out.print("-");
        }
        System.out.println("Out");*/

        // Login Authenticated
        return redirect(routes.DashboardController.postLogin());
    }

    public void updateName(String name){
        System.out.println("updated name");
        familyRef = name;
    }

    public Result getLogin() {
        return ok(views.html.login.render("Login"));
    }

    public Result getRegistration() {
        return ok(views.html.register.render("Register"));
    }

    public Result logout() {
        return redirect(routes.HomeController.index());
    }


}
