package com.awexa.awexa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kath on 10/16/2017.
 */

public class Family {
    private List<Child> children;
    private List<Parent> parents;
    private List<Chore> chores;
    private List<Reward> rewards;
    private String familyPass;

    public Family() {
        children = new ArrayList<>();
        parents = new ArrayList<>();
        chores = new ArrayList<>();
        rewards = new ArrayList<>();
        familyPass = "";
    }

    public Family(List<Parent> parents) {
        this.parents = parents;
        children = new ArrayList<>();
        chores = new ArrayList<>();
        rewards = new ArrayList<>();
        familyPass = "";
    }

    public Family(List<Parent> parents, List<Child> children) {
        this.parents = parents;
        this.children = children;
        chores = new ArrayList<>();
        rewards = new ArrayList<>();
        familyPass = "";
    }

    public Family(List<Parent> parents, List<Child> children, List<Chore> chores) {
        this.parents = parents;
        this.children = children;
        this.chores = chores;
        rewards = new ArrayList<>();
        familyPass = "";
    }

    public Family(List<Parent> parents, List<Child> children, List<Chore> chores, List<Reward> rewards) {
        this.parents = parents;
        this.children = children;
        this.chores = chores;
        this.rewards = rewards;
        familyPass = "";
    }

    public Family(List<Parent> parents, List<Child> children, List<Chore> chores, List<Reward> rewards, String familyPass) {
        this.parents = parents;
        this.children = children;
        this.chores = chores;
        this.rewards = rewards;
        this.familyPass = familyPass;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Chore> getChores() {
        return chores;
    }

    public void setChores(List<Chore> chores) {
        this.chores = chores;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public String getFamilyPass() {
        return familyPass;
    }

    public void setFamilyPass(String familyPass) {
        this.familyPass = familyPass;
    }
}
