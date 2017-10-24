package controllers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import model.Global;
import model.Family;
import java.util.HashMap;
import java.util.Map;

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
							FileInputStream serviceAccount = new FileInputStream("conf/service-account.json");
								fbOptions = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl("https://awexa-4bad0.firebaseio.com").build();
            } catch (IOException e) {
                e.printStackTrace();
            }
            FirebaseApp.initializeApp(fbOptions);
        }
        return true;
    }

    public static void updateSnapshot(String path) {

        //String path = "families/" + Global.familyName;
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
		
		/**
		 * adds object into database
		 * @param path database reference path
		 * @param obj obj data to be added
		 * @return String uniquely generated key
		 */
		public static String pushNode(String path, Object obj) {
			if (path != "" && obj != null) {
				DatabaseReference nodeRef = database.getReference(path);
				nodeRef.setValue(obj);
				//DatabaseReference newNode = nodeRef.push();
				//newNode.setValue(obj);
				return nodeRef.getKey();
			} else {
				return "null";
			}
		}

		/**
		 * updates family node to firebase
		 * @param family Family data
		 */
		public static void update(Family family) {
			DatabaseReference familyRef = database.getReference("/families/" + family.getID() + "/");
			Map<String, Object> familyUpdate = new HashMap<>();
			Map<String, Object> familyMap = family.toMap();
			familyUpdate.put("/families/" + family.getID(), familyMap);
			familyRef.updateChildren(familyMap);
		}

		public static void setExists(String path, boolean exists) {
			DatabaseReference reference = database.getReference(path);
			reference.setValue(exists);
		}


    final static FirebaseDatabase database = FirebaseDatabase.getInstance();

    public final static DatabaseReference USER_REF = database.getReference("families");

}