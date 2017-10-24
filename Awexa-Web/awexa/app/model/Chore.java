package model;
import java.util.Map;
import java.util.HashMap;

public class Chore {

    private String id;
    public String description;
    public String name;
		public int points;

		public Chore() {
			
		}

    public Chore(String i, String d, String n, int points) {
        this.id = i;
        this.description = d;
				this.name = n;
				this.points = points;
    }

    public String toString(){
        return name;
		}
		
		public Map<String, Object> toMap() {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("name", name);
			resultMap.put("description", description);
			resultMap.put("points", points);
			return resultMap;
		}
}
