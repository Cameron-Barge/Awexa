package model;

public class Chore {

    private String id;
    public String desc;
    public String name;
    public String rewardId;

    public Chore(String i, String d, String n, String r) {
        id = i;
        desc = d;
        name = n;
        rewardId = r;
    }

    public String toString(){
        return name;
    }
}
