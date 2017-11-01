package com.awexa.awexa;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Kath on 10/16/2017.
 */
public class Chore {
    private String choreId;
    private String name;
    private String description;
    private String childId;
    private Integer points;
    private HashMap<String, Object> recurrence;
    private Date due;
    private Date start;
    private Map<String, Integer> daysOfTheWeek;

    public Chore() {
        this("");
    }

    public Chore(String name) {
        this(name, "");
    }

    public Chore(String name, String description) {
        this.name = name;
        this.description = description;
        recurrence = new HashMap<>();
        daysOfTheWeek = new HashMap<>();
        daysOfTheWeek.put("Su", 0);
        daysOfTheWeek.put("M", 1);
        daysOfTheWeek.put("Tu", 2);
        daysOfTheWeek.put("W", 3);
        daysOfTheWeek.put("Th", 4);
        daysOfTheWeek.put("F", 5);
        daysOfTheWeek.put("Sa", 6);
    }

    public void setChoreId(String choreId) {
        this.choreId = choreId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setRecurrence(HashMap<String, Object> recurrence) {
        this.recurrence = recurrence;
        updateRecurrence();
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public String getChoreId() { return choreId; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public int getPoints() { return points; }

    public Map<String, Object> getRecurrence() { return recurrence; }

    private void updateRecurrence() {
        String frequency = (String)recurrence.get("repeat");
        Calendar date;
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

        switch (frequency) {
            case ("once"):
                start = convertDateString((String) recurrence.get("startDate"));
                due = convertDateString((String) recurrence.get("dueDate"));
                break;
            case ("daily"):
                // today
                date = new GregorianCalendar();
                // reset hour, minutes, seconds and millis
                try {
                    Date timeOfDayStart = sdf.parse((String)recurrence.get("startTime"));
                    Date timeOfDayEnd = sdf.parse((String)recurrence.get("endTime"));
                    date.set(Calendar.HOUR_OF_DAY, timeOfDayStart.getHours());
                    date.set(Calendar.MINUTE, timeOfDayStart.getMinutes());
                    date.set(Calendar.SECOND, 0);
                    date.set(Calendar.MILLISECOND, 0);
                    start = date.getTime();
                    date.set(Calendar.HOUR_OF_DAY, timeOfDayEnd.getHours());
                    date.set(Calendar.MINUTE, timeOfDayEnd.getMinutes());
                    due = date.getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                break;
            case ("weekly"):
                // today
                date = new GregorianCalendar();
                for (String day: ((HashMap<String, Boolean>)recurrence.get("days")).keySet()) {
                    try {
                        Date timeOfDayStart = sdf.parse((String)recurrence.get("startTime"));
                        Date timeOfDayEnd = sdf.parse((String)recurrence.get("endTime"));
                        if (daysOfTheWeek.get(day) >= date.get(Calendar.DAY_OF_WEEK)) {
                            date.add(Calendar.DAY_OF_WEEK, daysOfTheWeek.get(day));
                            date.set(Calendar.HOUR_OF_DAY, timeOfDayStart.getHours());
                            date.set(Calendar.MINUTE, timeOfDayStart.getMinutes());
                            date.set(Calendar.SECOND, 0);
                            date.set(Calendar.MILLISECOND, 0);
                            start = date.getTime();
                            date.set(Calendar.HOUR_OF_DAY, timeOfDayEnd.getHours());
                            date.set(Calendar.MINUTE, timeOfDayEnd.getMinutes());
                            due = date.getTime();
                            break;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                break;
            case ("monthly"):
                date = new GregorianCalendar();
                // reset hour, minutes, seconds and millis
                date.set(Calendar.DAY_OF_MONTH, 0);
                date.set(Calendar.HOUR_OF_DAY, 0);
                date.set(Calendar.MINUTE, 0);
                date.set(Calendar.SECOND, 0);
                date.set(Calendar.MILLISECOND, 0);
                start = date.getTime();
                date.add(Calendar.MONTH, 1);
                due = date.getTime();
                break;
            default:
                Log.d(name, "frequency error: " + frequency);
        }
    }

    private Date convertDateString(String dueDate) {
        if (dueDate != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
            dueDate = dueDate.replaceAll("\\+0([0-9]){1}\\:00", "+0$100");
            try {
                return df.parse(dueDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Chore) && ((Chore) other).choreId.equals(this.choreId);
    }

    public Date getDue() {
        return due;
    }

    public Date getStart() {
        return start;
    }
}
