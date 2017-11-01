package com.awexa.awexa;

import java.util.Map;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by Kath on 10/16/2017.
 */

public class Child {
    private String name;
    private Map<String, Boolean> chores; // These are chore IDs
    private Map<String, Integer> rewards; // These are reward IDs
    private int points;
    private String familyId;
    private String childId;

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

    public Map<String, Boolean> getChores() {
        return chores;
    }

    public void setChores(Map<String, Boolean> chores) {
        this.chores = chores;
    }

    public Map<String, Integer> getRewards() {
        return rewards;
    }

    public void setRewards(Map<String, Integer> rewards) {
        this.rewards = rewards;
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

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
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
