package com.awexa.awexa;

/**
 * Created by Kath on 10/16/2017.
 */

public class Reward extends Family {
    String name;
    String description;
    String rewardId;

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

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
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

    @Override
    public String toString() {
        return this.name;
    }

}
