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
    public String familyPass;
		public String familyName;
		private String id;

    public Family(){
			
    }

    public Family(String familyName, ArrayList<Child> children, ArrayList<Chore> chores, String familyPass, ArrayList<Parent> parents, ArrayList<Reward> rewards) {
        this.children = children;
				this.chores = chores;
        this.parents = parents;
        this.rewards = rewards;
				this.familyPass = familyPass;
        this.familyName = familyName;
		}
		
		public Family(String familyName, String familyPass) {
			this.familyName = familyName;
			this.familyPass = familyPass;
			children = new ArrayList<Child>();
			chores = new ArrayList<Chore>();
			parents = new ArrayList<Parent>();
			rewards = new ArrayList<Reward>();
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
