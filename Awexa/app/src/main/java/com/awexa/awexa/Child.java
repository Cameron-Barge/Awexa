package com.awexa.awexa;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kath on 10/16/2017.
 */

public class Child {
    public String name;
    public List<String> chores; // These are chore IDs

    public Child() {
        name = "testchild";
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

    public Child(String name, String[] chores) {
        this(name);
        for (String chore: chores) {
            this.chores.add(chore);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getChoreIds() { return chores; }

    public void setChores(List<String> chores) {
        this.chores = chores;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name;
    }
}
