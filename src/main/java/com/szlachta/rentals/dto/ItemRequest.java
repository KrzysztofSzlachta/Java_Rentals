package com.szlachta.rentals.dto;

import com.szlachta.rentals.models.ItemEntity;
import com.szlachta.rentals.models.PersonEntity;
import com.szlachta.rentals.validators.UniqueValue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ItemRequest {
    private int id;
    @NotBlank(message = "To pole jest wymagane")
    @Size(min = 3, max = 20, message = "Nazwa musi mieć od 3 do 20 znaków")
    @UniqueValue(entity = ItemEntity.class, field = "name", message = "Przedmiot o tej nazwie już istnieje")
    private String name;
    @NotBlank(message = "To pole jest wymagane")
    @Max(value = 100, message = "Opis musi być krótszy niż 200 znaków")
    private String description;
    @NotBlank(message = "To pole jest wymagane")
    @Size(min = 3, max = 20, message = "Typ musi mieć od 3 do 20 znaków")
    private String type;
    @NotBlank(message = "To pole jest wymagane")
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
