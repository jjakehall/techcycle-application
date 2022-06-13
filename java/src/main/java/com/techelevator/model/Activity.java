package com.techelevator.model;

import java.time.LocalDate;
import java.util.Date;

public class Activity {

    private int activityId;

    private String username;
    private int userId;
    private String activityName;
    private String activityDescription;
    private LocalDate activityDate; //Date correct?
    private double elapsedTime;
    private double activityDistance;
    private int activityElevation;
    private boolean activityPublic;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Activity() {
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(double elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public double getActivityDistance() {
        return activityDistance;
    }

    public void setActivityDistance(double activityDistance) {
        this.activityDistance = activityDistance;
    }

    public int getActivityElevation() {
        return activityElevation;
    }

    public void setActivityElevation(int activityElevation) {
        this.activityElevation = activityElevation;
    }

    public boolean getActivityPublic() {
        return activityPublic;
    }

    public void setActivityPublic(boolean activityPublic) {
        this.activityPublic = activityPublic;
    }

    public Activity(int activityId, int userId, String activityName, String activityDescription, LocalDate activityDate, int elapsedTime, double activityDistance, int activityElevation, boolean activityPublic) {
        this.activityId = activityId;
        this.userId = userId;
        this.activityName = activityName;
        this.activityDescription = activityDescription;
        this.activityDate = activityDate;
        this.elapsedTime = elapsedTime;
        this.activityDistance = activityDistance;
        this.activityElevation = activityElevation;
        this.activityPublic = activityPublic;
    }
}




