package com.awexa.awexa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kath on 10/16/2017.
 */

public class Child extends Family {
    private String name;
    private List<String> chores; // These are chore IDs
    private List<String> rewards; // These are reward IDs
    private int points;
    private String familyId;

    public Child() {
        name = "";
        chores = new ArrayList<>();
        rewards = new ArrayList<>();
        points = 0;
        familyId = "";
    }

    public Child(String name) {
        this.name = name;
        chores = new ArrayList<>();
        rewards = new ArrayList<>();
        points = 0;
        familyId = "";
    }

    public Child(String name, List<String> chores) {
        this.name = name;
        this.chores = chores;
        rewards = new ArrayList<>();
        points = 0;
        familyId = "";
    }

    public Child(String name, List<String> chores, List<String> rewards) {
        this.name = name;
        this.chores = chores;
        this.rewards = rewards;
        points = 0;
        familyId = "";
    }

    public Child(String name, List<String> chores, List<String> rewards, int points) {
        this.name = name;
        this.chores = chores;
        this.rewards = rewards;
        this.points = points;
        familyId = "";
    }

    public Child(String name, List<String> chores, List<String> rewards, String familyId) {
        this.name = name;
        this.chores = chores;
        this.rewards = rewards;
        points = 0;
        this.familyId = familyId;
    }

    public Child(String name, List<String> chores, List<String> rewards, int points, String familyId) {
        this.name = name;
        this.chores = chores;
        this.rewards = rewards;
        this.points = points;
        this.familyId = familyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRewardIds() { return rewards; }

    public void setRewardIds(List<String> rewards) {
        this.rewards = rewards;
    }

    public List<String> getChoreIds() { return chores; }

    public void setChoreIds(List<String> chores) {
        this.chores = chores;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }
}
