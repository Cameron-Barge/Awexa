package model;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Child {
    public String name;
		public String chores;
		private String id;
		public int points;
		public String familyId;
		public ArrayList<String> rewards;
		
		public Child() {

		}

    public Child(String name) {
        this.name = name;
		}
		
		public Child(String name, String familyId) {
			this.name = name;
			this.familyId = familyId;
		}

    public void setName(String name){
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
			resultMap.put("points", points);
			resultMap.put("familyId", familyId);
			resultMap.put("rewards", rewards);
			return resultMap;
		}

}
