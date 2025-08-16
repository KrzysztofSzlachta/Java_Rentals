package com.szlachta.rentals.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class ReservationRequest {
    @NotBlank( message = "to pole jest wymagane" )
    @FutureOrPresent
    private LocalDateTime startTime;
    @NotBlank( message = "to pole jest wymagane" )
    @Future
    private LocalDateTime endTime;
    @NotBlank( message = "to pole jest wymagane" )
    private PersonRequest person;
    @NotBlank( message = "to pole jest wymagane" )
    private ItemRequest item;

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

    public PersonRequest getPerson() {
        return person;
    }

    public void setPerson(PersonRequest person) {
        this.person = person;
    }

    public ItemRequest getItem() {
        return item;
    }

    public void setItem(ItemRequest item) {
        this.item = item;
    }
}
