package com.example.mukesh.androidassignment1;

import java.io.Serializable;

public class Players implements Serializable{
    private String name;
    private String country;
    private int worldRanking;
    private String shortInfo;
    private String completeInfo;
    private String image;
    private String url;

    public Players(String name, String country, int worldRanking, String shortInfo, String completeInfo, String image, String url) {
        this.name = name;
        this.country = country;
        this.worldRanking = worldRanking;
        this.shortInfo = shortInfo;
        this.completeInfo = completeInfo;
        this.image = image;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getWorldRanking() {
        return worldRanking;
    }

    public void setWorldRanking(int worldRanking) {
        this.worldRanking = worldRanking;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public String getCompleteInfo() {
        return completeInfo;
    }

    public void setCompleteInfo(String completeInfo) {
        this.completeInfo = completeInfo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
