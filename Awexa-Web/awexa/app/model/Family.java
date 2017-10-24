package model;

import com.google.firebase.database.*;
import controllers.FirebaseServices;
import play.data.FormFactory;
import java.util.ArrayList;

import javax.inject.Inject;

public class Family {
		public ArrayList<Child> children;
		public ArrayList<Chore> chores;
		public ArrayList<Parent> parents;
		public ArrayList<Reward> rewards;
    private String familyPass;
    public String familyName;

    public Family(){

    }

    public Family(String famName, ArrayList<Child> children, ArrayList<Chore> chores, String fpass, ArrayList<Parent> parents, ArrayList<Reward> rewards) {
        this.children = children;
				this.chores = chores;
        this.parents = parents;
        this.rewards = rewards;
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

public void addChild(Child child) {
		children.add(child);
}

public void addChore(Chore chore) {
	chores.add(chore);
}

public void addReward(Reward reward) {
	rewards.add(reward);
}

public void addParent(Parent parent) {
	parents.add(parent);
}


}
