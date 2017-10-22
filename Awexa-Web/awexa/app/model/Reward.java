package model;

public class Reward {

    public String id;
    public String desc;
    public String name;

    public Reward(String i, String d, String n){
        id = i;
        desc = d;
        name = n;
    }

    public String toString(){
        return name;
    }
}

