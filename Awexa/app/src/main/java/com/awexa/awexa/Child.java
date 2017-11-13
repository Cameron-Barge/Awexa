package com.awexa.awexa;

import java.util.HashMap;

/**
 * Created by Kath on 10/16/2017.
 */

public class Child {
    String name;
    HashMap<String, String> chores; // These are chore IDs
    HashMap<String, Integer> rewards; // These are chore IDs
    int points; // These are chore IDs
    String familyId;

    String childId;

    public Child() {
        chores = new HashMap<>();
        rewards = new HashMap<>();
    }

    public Child(String name, String familyId) {
        this.name = name;
        this.familyId = familyId;
        chores = new HashMap<>();
        rewards = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public void setChores(HashMap<String, String> chores) {
        this.chores = chores;
    }

    public void setRewards(HashMap<String, Integer> rewards) {
        this.rewards = rewards;
    }


    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Child) && ((Child) other).childId.equals(this.childId);
    }
}