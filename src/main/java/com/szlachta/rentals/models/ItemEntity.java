package com.szlachta.rentals.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenerationTime;

@Entity(name = "items")
public class ItemEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ItemsGenerator")
    @SequenceGenerator(name = "ItemsGenerator", sequenceName = "items_id_item_seq", allocationSize = 1)
    @Id
    @Column(name = "id_item")
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String type;

    @Column(name = "adult_required")
    private boolean adultRequired;

    @Column
    private boolean deleted;

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

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
