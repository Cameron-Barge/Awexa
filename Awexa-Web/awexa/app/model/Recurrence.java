package model;
import java.util.Map;
import java.util.HashMap;

public class Recurrence {

    public String repeat;
    public Map<String, String> days;
    public String startTime;
    public String endTime;
    final public static String[] WEEK = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public Recurrence() {

    }

    public Recurrence(String startTime, String endTime, String repeat, Map<String, String> days) {
        this.repeat = repeat;
        this.startTime = startTime;
        this.endTime = endTime;
        this.repeat = repeat;
        this.days = days;
    }

    public Map<String, Object> toMap() {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("startTime", startTime);
		resultMap.put("endTime", endTime);
		resultMap.put("repeat", repeat);
        resultMap.put("days", days);
		return resultMap;
	}

    public static String[] getWeek() {
        return WEEK;
    }
}