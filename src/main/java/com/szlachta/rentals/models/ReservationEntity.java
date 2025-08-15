package com.szlachta.rentals.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "reservations")
public class ReservationEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReservationsGenerator")
    @SequenceGenerator(name = "ReservationsGenerator", sequenceName = "reservations_id_reservation_seq", allocationSize = 1)
    @Id
    @Column(name = "id_reservation")
    private int id;
    @Column(name = "starting_time")
    private LocalDateTime startTime;
    @Column(name = "ending_time")
    private LocalDateTime endTime;
    @Column
    private boolean deleted;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    private PersonEntity person;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    private ItemEntity item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }
}
