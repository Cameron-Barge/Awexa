package model;
import java.util.ArrayList;

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

}
