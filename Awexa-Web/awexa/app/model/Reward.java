package model;
import java.util.Map;
import java.util.HashMap;

public class Reward {

    private String id;
    public String description;
		public String name;
		public int points;

		public Reward() {
			
		}

    public Reward(String description, String name, int points){
        this.points = points;
        this.description = description;
        this.name = name;
    }

    public String toString(){
        return name;
		}
		
		public String getID() {
			return id;
		}

		public void setID(String id) {
			this.id = id;
		}

		public Map<String, Object> toMap() {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("name", name);
			resultMap.put("description", description);
			resultMap.put("points", points);
			return resultMap;
		}
}

