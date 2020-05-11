package com.example.idea.dataModel;

import java.util.UUID;

public class User {
    UUID uuid;
    String name;
    String food;
    int rating;
    Boolean hasOffer;

    public User(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public User(UUID uuid, String name, int rating) {
        this.uuid = uuid;
        this.name = name;
        this.rating = rating;
    }

    public User(UUID uuid, String name, String food, int rating, Boolean hasOffer) {
        this.uuid = uuid;
        this.name = name;
        this.food = food;
        this.rating = rating;
        this.hasOffer = hasOffer;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Boolean getHasOffer() {
        return hasOffer;
    }

    public void setHasOffer(Boolean hasOffer) {
        this.hasOffer = hasOffer;
    }
}
