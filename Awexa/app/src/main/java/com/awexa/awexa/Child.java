package com.awexa.awexa;

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
    String name;
    HashMap<String, Boolean> chores; // These are chore IDs
    HashMap<String, Boolean> earnedRewards; // These are chore IDs
    String childId;

    public Child() {
        chores = new HashMap<>();
        earnedRewards = new HashMap<>();
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

    public void setChores(HashMap<String, Boolean> chores) {
        this.chores = chores;
    }

    public void setEarnedRewards(HashMap<String, Boolean> earnedRewards) {
        this.earnedRewards = earnedRewards;
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
