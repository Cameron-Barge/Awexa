package model;

public class Parent {
    public String id;
    private String pass;

    public Parent(String i, String p){
        id = i;
        pass = p;
    }

    public String toString(){
        return id;
    }
}
