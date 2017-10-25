package model;
import java.util.Map;
import java.util.HashMap;

public class Parent {
		public String familyId;
		private String id;
		private String firstName;
		private String lastName;
		public String pass;
		
		public Parent() {

		}

    public Parent(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
		}

		public Parent(String firstName, String lastName, String familyId){
			this.firstName = firstName;
			this.lastName = lastName;
			this.familyId = familyId;
	}

    public String toString(){
        return id;
		}
		
		public String getName() {
			return firstName + " " + lastName;
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
			resultMap.put("name", firstName + " " + lastName);
			resultMap.put("familyId", familyId);
			resultMap.put("pass", pass);
			return resultMap;
		}
}
