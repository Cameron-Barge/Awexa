package controllers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import model.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FirebaseServices {
    public static FirebaseOptions fbOptions;
    public static boolean firebaseLoaded = initFirebase();

    public FirebaseServices() {
    }

    private static boolean initFirebase() {
        System.out.println("Apps: " + FirebaseApp.getApps().size());

        if (FirebaseApp.getApps().isEmpty()) {
            System.out.println("Initialize Firebase");
            try {
                FileInputStream serviceAccount = new FileInputStream("conf/service-account.json");
                fbOptions = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setDatabaseUrl("https://awexa-4bad0.firebaseio.com").build();
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
    }

    public static void createNode(String path, String key, Object obj) {
        if (path != "" && obj != null) {
            DatabaseReference nodeRef = database.getReference(path);
            nodeRef.child(key).setValue(obj);
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
            DatabaseReference newNode = nodeRef.push();
            newNode.setValue(obj);
            return newNode.getKey();
        } else {
            return "null";
        }
    }

    /**
     * updates family node to firebase
     * @param family Family data
     */
    public static void update(Family family) {
        DatabaseReference familyRef = database.getReference("/families/" + family.getFamilyName() + "/");
        Map<String, Object> familyUpdate = new HashMap<>();
        Map<String, Object> familyMap = family.toMap();
        familyUpdate.put("/families/" + family.getFamilyName(), familyMap);
        familyRef.updateChildren(familyMap);
    }

    public static void setExists(String path, boolean exists) {
        DatabaseReference reference = database.getReference(path);
        reference.setValue(exists);
    }

    public static ArrayList<Chore> getChoresFromDB(String familyID) {
        DatabaseReference familyRef = database.getReference("families/" + familyID + "/chores");

        ArrayList<String> choreIDs = new ArrayList<>();
        familyRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot choreSnapshot : dataSnapshot.getChildren()) {
                        choreIDs.add((String)choreSnapshot.getValue());
                    }
            }

            public void onCancelled(DatabaseError databaseError) {

            }
        });
        try {
            Thread.sleep(500);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
        return parseChoreIDs(choreIDs);

        /*
        DatabaseReference dbRef = database.getReference("chores");
        ArrayList<Chore> chores = new ArrayList<>();
        dbRef.orderByChild("name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot choreSnapshot : dataSnapshot.getChildren()) {
                    Chore chore = choreSnapshot.getValue(Chore.class);
                    chores.add(chore);
                }
            }

            public void onCancelled(DatabaseError databaseError) {

            }
        });
        while (chores.isEmpty()) {
            try {
                Thread.sleep(500);
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
        return chores;
        */
    }

    public static ArrayList<Chore> parseChoreIDs(ArrayList<String> choreIDs) {
        DatabaseReference choresRef = database.getReference("chores");
        ArrayList<Chore> chores = new ArrayList<>();

        choresRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot choreSnapshot : dataSnapshot.getChildren()) {
                    if (choreIDs.indexOf(choreSnapshot.getKey()) != -1)  {
                        Chore chore = choreSnapshot.getValue(Chore.class);
                        chores.add(chore);
                    }
                }
            }

            public void onCancelled(DatabaseError databaseError) {

            }
        });
        try {
                Thread.sleep(500);
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
        }
        
        return chores;
    }

    public static ArrayList<Reward> getRewardsFromDB(String familyID) {
        DatabaseReference familyRef = database.getReference("families/" + familyID + "/rewards");

        ArrayList<String> rewardIDs = new ArrayList<>();
        familyRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot rewardSnapshot : dataSnapshot.getChildren()) {
                        rewardIDs.add((String)rewardSnapshot.getValue());
                    }
            }

            public void onCancelled(DatabaseError databaseError) {

            }
        });
        try {
            Thread.sleep(500);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
        return parseRewardIDs(rewardIDs);
    }

    public static ArrayList<Reward> parseRewardIDs(ArrayList<String> rewardIDs) {
        DatabaseReference rewardsRef = database.getReference("rewards");
        ArrayList<Reward> rewards = new ArrayList<>();

        rewardsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot rewardSnapshot : dataSnapshot.getChildren()) {
                    if (rewardIDs.indexOf(rewardSnapshot.getKey()) != -1)  {
                        Reward reward = rewardSnapshot.getValue(Reward.class);
                        rewards.add(reward);
                    }
                }
            }

            public void onCancelled(DatabaseError databaseError) {

            }
        });
        try {
                Thread.sleep(500);
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
        }
        
        //return new ArrayList<Reward>(rewards.subList(1,5));
        return rewards;
    }

    final static FirebaseDatabase database = FirebaseDatabase.getInstance();

    public final static DatabaseReference USER_REF = database.getReference("families");

}