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

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    FirebaseServices db = new FirebaseServices();
    @Inject FormFactory formFactory;
    // Get a reference to our posts

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        //getFamily("family4");

        //System.out.println("Session Test");
        //session().put("connected","test");
        //session("connected","test");
        //System.out.println("Assigned : " + session("connected"));
        //System.out.println("Assigned : " + session().get("connected"));

        return ok(views.html.index.render("Welcome to Awexa"));
    }

    public void getFamily(String fam) {


        /*Global.waiting = true;

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        String path = "families/" + fam;
        System.out.println(path);
        DatabaseReference ref = database.getReference(path);

        // Attach a listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataSnapshot children = dataSnapshot.child("children");

                System.out.println(dataSnapshot);
                System.out.println("Children:");
                System.out.println(children);
                System.out.println("Pass:");
                System.out.println(dataSnapshot.child("familyPass").getValue());
                Global.waiting = false;
                //Family fam = dataSnapshot.getValue(Family.class);

                //fam.print();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        while(Global.waiting){}
        System.out.println("TEST");*/
    }







}
