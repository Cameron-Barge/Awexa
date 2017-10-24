package model;

public class Reward {

    public String id;
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
}

