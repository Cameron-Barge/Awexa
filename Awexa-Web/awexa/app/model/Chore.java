package model;

import java.util.Map;
import java.util.HashMap;

public class Chore {

	private String id;
	private String childId;
	public String description;
	public String name;
	public int points;
	public Recurrence recurrence;

	public Chore() {

	}

	public Chore(String i, String d, String n, int points) {
		this.id = i;
		this.description = d;
		this.name = n;
		this.points = points;
	}

	public Chore(String name, String description, int points, Recurrence recurrence) {
		this.name = name;
		this.description = description;
		this.points = points;
		this.recurrence = recurrence;
	}

	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getID() {
		return id;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("name", name);
		resultMap.put("description", description);
		resultMap.put("points", points);
		resultMap.put("recurrence", recurrence.toMap());
		return resultMap;
	}
}