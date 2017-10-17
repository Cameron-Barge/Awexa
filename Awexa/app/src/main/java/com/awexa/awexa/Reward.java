package com.awexa.awexa;

/**
 * Created by Kath on 10/16/2017.
 */

public class Reward extends Family {
    private String name;
    private String description;

    public Reward() {
        name = "";
        description = "";
    }

    public Reward(String name) {
        this.name = name;
        description = "";
    }

    public Reward(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
