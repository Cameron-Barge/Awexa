package com.awexa.awexa;

/**
 * Created by Kath on 10/16/2017.
 */

public class Parent extends Family {
    private String name;
    private String password;

    public Parent() {
        name = "";
        password = "";
    }

    public Parent(String name) {
        this.name = name;
        password = "";
    }

    public Parent(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }
}
