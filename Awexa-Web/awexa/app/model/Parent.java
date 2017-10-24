package model;

public class Parent {
		public String id;
		public String firstName;
    private String pass;

    public Parent(String firstName, String pass){
        this.pass = pass;
        this.firstName = firstName;
    }

    public String toString(){
        return id;
		}
		
		public String getName() {
			return firstName;
		}
}
