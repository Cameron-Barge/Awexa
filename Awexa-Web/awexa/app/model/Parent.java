package model;
import java.util.Map;
import java.util.HashMap;

public class Parent {
		public String familyId;
		private String id;
		public String name;
		private String pass;
		
		public Parent() {

		}

    public Parent(String name, String pass){
        this.pass = pass;
        this.name = name;
		}

		public Parent(String name, String pass, String familyId){
			this.pass = pass;
			this.name = name;
			this.familyId = familyId;
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

		public String getFamilyId() {
			return familyId;
		}

		public Map<String, Object> toMap() {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("name", name);
			resultMap.put("familyId", familyId);
			resultMap.put("pass", pass);
			return resultMap;
		}
}
