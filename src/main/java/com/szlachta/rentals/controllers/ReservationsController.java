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
    public void createReservation(@RequestBody ReservationRequest reservationRequest,
                                  @RequestParam("idPerson") int idPerson, @RequestParam("idItem") int idItem) {
        reservationsService.createReservation(reservationRequest, idPerson, idItem);
    }

    @PutMapping
    public void updateReservation(@RequestParam int idReservation, @RequestParam int idPerson, @RequestParam int idItem,
                                  @RequestBody ReservationRequest reservationRequest) {
        reservationsService.updateReservation(reservationRequest, idReservation, idPerson, idItem);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationsService.deleteReservation(id);
    }
}
