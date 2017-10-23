package com.awexa.awexa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kath on 10/16/2017.
 */

public class Child extends Family {
    private String name;
    private List<String> chores; // These are chore IDs

    public Child() {
        name = "";
        chores = new ArrayList<>();
    }

    public Child(String name) {
        this.name = name;
        this.chores = new ArrayList<>();
    }

    public Child(String name, List<String> chores) {
        this.name = name;
        this.chores = chores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getChoreIds() { return chores; }

    public void setChoreIds(List<String> chores) {
        this.chores = chores;
    }
}
