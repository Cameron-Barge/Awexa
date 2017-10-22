package model;

import com.google.firebase.database.*;
import controllers.FirebaseServices;
import play.data.FormFactory;

import javax.inject.Inject;

public class Family {
    public Child[] children;
    public Chore[] chores;
    public Parent[] parents;
    public Reward[] rewards;
    private String familyPass;
    public String familyName;

    public Family(){

    }

    public Family(String famName, Child[] children1, Chore[] chores1, String fpass, Parent[] parents1, Reward[] rewards1) {
        children = children1;
        chores = chores1;
        parents = parents1;
        rewards = rewards1;
        familyPass = fpass;
        familyName = famName;
    }

    public void print(){
        System.out.println("Family: " + familyName);
        System.out.println("Children:");
        for(Child c : children) {
            System.out.println(c);
        }
        System.out.println("Chores:");
        for(Chore c: chores) {
            System.out.println(c);
        }
        System.out.println("Parents");
        for(Parent p : parents) {
            System.out.println(p);
        }
        System.out.println("Rewards");
        for(Reward r : rewards) {
            System.out.println(r);
        }
    }

    public static Family authenticate(String user, String pass) {
        Family fam = new Family();
        boolean waiting = true;

        /*final FirebaseDatabase database = FirebaseDatabase.getInstance();
        String path = "families/" + fam;
        System.out.println(path);
        DatabaseReference ref = database.getReference(path);

        // Attach a listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println(dataSnapshot);
                Family fam = dataSnapshot.getValue(Family.class);
                fam.print();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        while(waiting) {
*/

        return fam;


    }


}
