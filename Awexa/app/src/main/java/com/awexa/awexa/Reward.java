package com.awexa.awexa;

/**
 * Created by Kath on 10/16/2017.
 */
public class Reward {
    private String name;
    private String description;
    private String rewardId;
    private int points;

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

    public void setPoints(int points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Reward) && ((Reward) other).rewardId.equals(this.rewardId);
    }

    public String getRewardId() {
        return rewardId;
    }

    public int getPoints() {
        return points;
    }
}
