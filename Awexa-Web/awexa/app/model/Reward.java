package model;

public class Reward {

    private String id;
    public String description;
		public String name;
		public int points;

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
}

