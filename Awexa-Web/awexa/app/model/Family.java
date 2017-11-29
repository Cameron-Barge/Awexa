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
	public ArrayList<Parent> parents;
	public ArrayList<String> parentIDs;
	public ArrayList<Reward> rewards;
	public ArrayList<String> choreIDs;
	public ArrayList<String> rewardIDs;
	public String familyPass;
	public String familyName;
	private String id;

	public Family() {

	}

	public Family(String id, String familyPass) {
		this.id = id;
		this.familyPass = familyPass;
		children = new ArrayList<Child>();
		chores = new ArrayList<Chore>();
		parents = new ArrayList<Parent>();
		rewards = new ArrayList<Reward>();
		childrenIDs = new ArrayList<String>();
		rewardIDs = new ArrayList<String>();
		choreIDs = new ArrayList<String>();
		parentIDs = new ArrayList<String>();
	}

	public void print() {
		System.out.println("Family: " + familyName);
		System.out.println("Children:");
		for (Child c : children) {
			System.out.println(c);
		}
		System.out.println("Chores:");
		for (Chore c : chores) {
			System.out.println(c);
		}
		System.out.println("Parents");
		for (Parent p : parents) {
			System.out.println(p);
		}
		System.out.println("Rewards");
		for (Reward r : rewards) {
			System.out.println(r);
		}
	}

	public void addChild(Child child) {
		children.add(child);
		if (child.getID() != null) {
			childrenIDs.add(child.getID());
		}
	}

	public void addChore(Chore chore) {
		chores.add(chore);
		choreIDs.add(chore.getID());
	}

	public void addReward(Reward reward) {
		rewards.add(reward);
		rewardIDs.add(reward.getID());
	}

	public void addParent(Parent parent) {
		parents.add(parent);
		parentIDs.add(parent.getID());
	}

	public void setChores(ArrayList<Chore> chores) {
		this.chores = chores;
		this.choreIDs = new ArrayList<>();
		for (Chore chore : chores) {
			choreIDs.add(chore.getID());
		}
	}

	public void setRewards(ArrayList<Reward> rewards) {
		this.rewards = rewards;
		this.rewardIDs = new ArrayList<>();
		for (Reward reward : rewards) {
			rewardIDs.add(reward.getID());
		}
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String toString() {
		return familyName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("familyName", familyName);
		resultMap.put("children", childrenIDs);
		resultMap.put("parents", parentIDs);
		resultMap.put("rewards", rewardIDs);
		resultMap.put("chores", choreIDs);
		resultMap.put("familyPass", familyPass);
		return resultMap;
	}

}
