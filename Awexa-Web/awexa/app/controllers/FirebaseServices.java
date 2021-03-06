package controllers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import model.Global;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FirebaseServices {

    public static FirebaseOptions fbOptions;
    public static boolean firebaseLoaded = initFirebase();

    public FirebaseServices(){
    }


    private static boolean initFirebase(){
        System.out.println("Apps: " +  FirebaseApp.getApps().size());

        if(FirebaseApp.getApps().isEmpty()){
            System.out.println("Initialize Firebase");
            try{
                fbOptions= new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(new FileInputStream("conf/service-account.json"))).setDatabaseUrl("https://awexa-4bad0.firebaseio.com").build();
            } catch (IOException e) {
                e.printStackTrace();
            }
            FirebaseApp.initializeApp(fbOptions);
        }
        return true;
    }

    public static void updateSnapshot() {

        String path = "families/" + Global.familyName;
        DatabaseReference ref = database.getReference(path);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Global.curRef = dataSnapshot;

                Global.waiting = false;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        int count = 0;
        while(Global.waiting){
            count++;
            if(count > 200){
                System.out.print(".");
                count = 0;
            }

        }
    }


    final static FirebaseDatabase database = FirebaseDatabase.getInstance();

    public final static DatabaseReference USER_REF = database.getReference("families");

}