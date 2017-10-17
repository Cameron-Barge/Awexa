package com.awexa.awexa;

/**
 * Created by Kath on 10/16/2017.
 */

public class Chore extends Family {
    private String name;
    private String description;
    private String rewardId;

    public Chore() {
        name = "";
        description = "";
        rewardId = "";
    }

    public Chore(String name) {
        this.name = name;
        description =  "";
        rewardId = "";
    }

    public Chore(String name, String description, String rewardId) {
        this.name = name;
        this.description = description;
        this.rewardId = rewardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.name = description;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }
}
