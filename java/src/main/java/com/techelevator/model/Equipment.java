package com.techelevator.model;

public class Equipment {
    private int equipmentId;
    private int userId;
    private String nickname;
    private String bikeBrand;
    private String bikeModel;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBikeBrand() {
        return bikeBrand;
    }

    public void setBikeBrand(String bikeBrand) {
        this.bikeBrand = bikeBrand;
    }

    private int bikeWeight;

    public Equipment(int equipmentId, int userId, String bikeModel, int bikeWeight) {
        this.equipmentId = equipmentId;
        this.userId = userId;
        this.bikeModel = bikeModel;
        this.bikeWeight = bikeWeight;
    }
    public Equipment() {};

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public int getBikeWeight() {
        return bikeWeight;
    }

    public void setBikeWeight(int bikeWeight) {
        this.bikeWeight = bikeWeight;
    }
}