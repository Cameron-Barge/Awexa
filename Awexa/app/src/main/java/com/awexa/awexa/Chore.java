package com.awexa.awexa;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kath on 10/16/2017.
 */

public class Chore extends Family {
    String choreId;
    String name;
    String description;
    String childId;
    String rewardId;
    Date dueDate;

    public void setChoreId(String choreId) {
        Log.d("date", "try");
        this.choreId = choreId;
    }

    public void setName(String name) {
        Log.d("date", "try");
        this.name = name;
    }

    public void setDescription(String description) {
        Log.d("date", "try");
        this.name = description;
    }

    public void setRewardId(String rewardId) {
        Log.d("date", "try");
        this.rewardId = rewardId;
    }

    public void setChildId(String childId) {
        Log.d("date", "try");
        this.childId = childId;
    }

    public void setDueDate(String dueDate) {
        Log.d("date", "try");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
        dueDate = dueDate.replaceAll("\\+0([0-9]){1}\\:00", "+0$100");
        try {
            this.dueDate = df.parse(dueDate);
            Log.d("date", this.dueDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

}
