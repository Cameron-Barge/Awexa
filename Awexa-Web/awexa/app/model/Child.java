package model;

public class Child {
    public String childName;
    public String chores;

    public Child(String ch) {
        chores = ch;
    }

    public void setName(String name){
        childName = name;
    }
    public String toString(){
        return childName;
    }

}
