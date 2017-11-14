package model;
import java.util.Map;
import java.util.HashMap;

import com.google.firebase.database.*;
import controllers.FirebaseServices;
import play.data.FormFactory;
import java.util.ArrayList;

import javax.inject.Inject;

public class Family {
		public ArrayList<Child> children;
		private ArrayList<String> childrenIDs;
		public ArrayList<Chore> chores;
		public ArrayList<String> parents;
		public ArrayList<Reward> rewards;
    public String familyPass;
		private String familyName;
	
    public Family(){
			
    }

    public Family(String familyName, ArrayList<Child> children, ArrayList<Chore> chores, String familyPass, ArrayList<String> parents, ArrayList<Reward> rewards) {
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
			parents = new ArrayList<String>();
			rewards = new ArrayList<Reward>();
			childrenIDs = new ArrayList<String>();
		}

    public void print(){
        System.out.println("Username: " + familyName);
        System.out.println("Children:");
        for(Child c : children) {
            System.out.println(c);
        }
        System.out.println("Chores:");
        for(Chore c: chores) {
            System.out.println(c);
        }
        System.out.println("Rewards");
        for(Reward r : rewards) {
        System.out.println(r);
    }
	}

	public String getFamilyName() {
		return familyName;
	}

	public void addChild(Child child) {
			children.add(child);
			if (child.getID() != null) {
				childrenIDs.add(child.getID());
			}
	}

	public void addChore(Chore chore) {
		chores.add(chore);
	}

	public void addReward(Reward reward) {
		rewards.add(reward);
	}

	public void addParent(String parent) {
		parents.add(parent);
	}


	public void addParent(Parent parent) {
		if (parent.getID() != null) {
			parents.add(parent.getID());
		}
	}

	public String toString() {
		return familyName;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("familyName", familyName);
		resultMap.put("children", childrenIDs);
		resultMap.put("parents", parents);
		// resultMap.put("child_names", children);
		resultMap.put("familyPass", familyPass);
		return resultMap;
	}

}
