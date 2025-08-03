package com.szlachta.rentals.dto;

import jakarta.validation.constraints.NotBlank;

public class ItemRequest {
    private int id;
    @NotBlank(message = "To pole jest wymagane")
    private String name;
    private String description;
    @NotBlank(message = "To pole jest wymagane")
    private String type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getAdultRequired() {
        return adultRequired;
    }

    public void setAdultRequired(boolean adultRequired) {
        this.adultRequired = adultRequired;
    }
}
