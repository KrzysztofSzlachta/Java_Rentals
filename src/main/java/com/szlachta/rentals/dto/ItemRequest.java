package com.szlachta.rentals.dto;

public class ItemRequest {
    private int id;
    private String name;
    private String description;
    private boolean adultRequired;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.description = description;
    }

    public boolean isAdultRequired() {
        return adultRequired;
    }

    public void setAdultRequired(boolean adultRequired) {
        this.adultRequired = adultRequired;
    }
}
