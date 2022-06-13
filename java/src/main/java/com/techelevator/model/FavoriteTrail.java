package com.techelevator.model;

public class FavoriteTrail {

    private int trailId;
    private int userId;
    private String name;
    private double distance;
    private String description;
    private String difficulty;
    private String grade;

    public FavoriteTrail(int trailId, int userId, String name, double distance, String description, String difficulty, String grade) {
        this.trailId = trailId;
        this.userId = userId;
        this.name = name;
        this.distance = distance;
        this.description = description;
        this.difficulty = difficulty;
        this.grade = grade;
    }

    public FavoriteTrail(){}

    public int getTrailId() {
        return trailId;
    }

    public void setTrailId(int trailId) {
        this.trailId = trailId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
