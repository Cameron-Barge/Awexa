package model;
import java.util.Map;
import java.util.HashMap;

public class Parent {
		private String id;
		public String name;
		private String pass;
		
		public Parent() {

		}

    public Parent(String name, String pass){
        this.pass = pass;
        this.name = name;
		}
		
		public Parent(String name) {
			this.name = name;
		}

    public String toString(){
        return name;
		}
		
		public String getName() {
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
			resultMap.put("pass", pass);
			return resultMap;
		}
}
