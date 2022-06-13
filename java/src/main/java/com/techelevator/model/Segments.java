package com.techelevator.model;

public class Segments
{
    private String name;
    private String segmentId;
    private String elevationGain;
    private String distance;
    private String grade;

    public Segments(String name, String segmentId, String elevationGain, String distance, String grade) {
        this.name = name;
        this.segmentId = segmentId;
        this.elevationGain = elevationGain;
        this.distance = distance;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElevationGain() {
        return elevationGain;
    }

    public void setElevationGain(String elevationGain) {
        this.elevationGain = elevationGain;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(String segmentId) {
        this.segmentId = segmentId;
    }
}
