package com.szlachta.rentals.controllers;

import com.szlachta.rentals.dto.ReservationRequest;
import com.szlachta.rentals.dto.ReservationResponse;
import com.szlachta.rentals.dto.SearchByItemReservationResponse;
import com.szlachta.rentals.dto.SearchByPersonReservationResponse;
import com.szlachta.rentals.services.ReservationsService;
import jakarta.validation.Valid;
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
    public void createReservation(@RequestBody @Valid ReservationRequest reservationRequest,
                                  @RequestParam("idPerson") int idPerson, @RequestParam("idItem") int idItem) {
        reservationsService.createReservation(reservationRequest, idPerson, idItem);
    }

    @PutMapping
    public void updateReservation(@Valid @RequestBody ReservationRequest reservationRequest,
                                  @RequestParam int idReservation, @RequestParam int idPerson, @RequestParam int idItem
                                  ) {
        reservationsService.updateReservation(reservationRequest, idReservation, idPerson, idItem);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationsService.deleteReservation(id);
    }

    @GetMapping("/search/byPerson")
    public List<SearchByPersonReservationResponse> searchByPerson(@RequestParam int idPerson) {
        return reservationsService.getReservationsByPerson(idPerson);
    }

    @GetMapping("/dev/search/byPerson")
    public List<SearchByPersonReservationResponse> searchByPersonDev(@RequestParam int idPerson) {
        return reservationsService.getReservationsByPersonDev(idPerson);
    }

    @GetMapping("/search/byItem")
    public List<SearchByItemReservationResponse> searchByItem(@RequestParam int idItem) {
        return reservationsService.getReservationsByItem(idItem);
    }

    @GetMapping("/dev/search/byItem")
    public List<SearchByItemReservationResponse> searchByItemDev(@RequestParam int idItem) {
        return reservationsService.getReservationsByItemDev(idItem);
    }
}
