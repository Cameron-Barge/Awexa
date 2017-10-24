package model;

public class Parent {
		public String familyId;
		private String id;
		public String name;
    private String pass;

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
        return id;
		}
		
		public String getName() {
			return name;
		}

		public String getID() {
			return id;
		}

		public String getFamilyId() {
			return familyId;
		}
}
