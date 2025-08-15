package com.szlachta.rentals.controllers;

import com.szlachta.rentals.dto.ReservationRequest;
import com.szlachta.rentals.dto.ReservationResponse;
import com.szlachta.rentals.services.ReservationsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationsController {
    private final ReservationsService reservationsService;

    public ReservationsController(ReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    @GetMapping("/{id}")
    public ReservationResponse getReservationById(@PathVariable int id) {
        return reservationsService.getReservationById(id);
    }

    @GetMapping
    public List<ReservationResponse> getAllReservations() {
        return reservationsService.getAllReservations();
    }

    @PostMapping
    public void createReservation(@RequestBody ReservationRequest reservationRequest) {
        reservationsService.createReservation(reservationRequest);
    }

    @PutMapping("/{id}")
    public void updateReservation(@PathVariable int id, @RequestBody ReservationRequest reservationRequest) {
        reservationsService.updateReservation(reservationRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationsService.deleteReservation(id);
    }
}
