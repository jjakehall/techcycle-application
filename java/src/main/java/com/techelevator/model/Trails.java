package com.techelevator.model;

public class Trails
{
    private String name;
    private String trailUrl;
    private double distance;
    private String description;
    private String difficulty;

    public Trails(String name, String trailUrl, double distance, String description, String difficulty) {
        this.name = name;
        this.trailUrl = trailUrl;
        this.distance = distance;
        this.description = description;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrailUrl() {
        return trailUrl;
    }

    public void setTrailUrl(String trailUrl) {
        this.trailUrl = trailUrl;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
