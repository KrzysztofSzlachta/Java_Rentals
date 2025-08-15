package com.szlachta.rentals.services;

import com.szlachta.rentals.dto.ReservationRequest;
import com.szlachta.rentals.dto.ReservationResponse;
import com.szlachta.rentals.exceptions.NotFoundException;
import com.szlachta.rentals.mappers.ItemMapper;
import com.szlachta.rentals.mappers.PersonMapper;
import com.szlachta.rentals.mappers.ReservationMapper;
import com.szlachta.rentals.models.ReservationEntity;
import com.szlachta.rentals.repositories.ReservationsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationsService {
    private final ReservationsRepository reservationsRepository;
    private final ReservationMapper reservationMapper;
    private final PersonMapper personMapper;
    private final ItemMapper itemMapper;

    public ReservationsService(ReservationsRepository reservationsRepository, ReservationMapper reservationMapper) {
        this.reservationsRepository = reservationsRepository;
        this.reservationMapper = reservationMapper;
        this.personMapper = new PersonMapper();
        this.itemMapper = new ItemMapper();
    }

    public ReservationResponse getReservationById(int id) {
        ReservationEntity reservationEntity = reservationsRepository.findById(id).orElse(null);
        if (reservationEntity == null) {
            throw new NotFoundException("Reservation not found");
        }
        return reservationMapper.fromEntity(reservationEntity);
    }

    public List<ReservationResponse> getAllReservations() {
        Iterable<ReservationEntity> reservationEntities = reservationsRepository.findAll();
        List<ReservationResponse> reservationResponses = new ArrayList<>();
        for (ReservationEntity reservationEntity : reservationEntities) {
            reservationResponses.add(reservationMapper.fromEntity(reservationEntity));
        }
        return reservationResponses;
    }

    public void createReservation(ReservationRequest reservationRequest) {
        reservationsRepository.save(reservationMapper.fromRequest(reservationRequest));
    }

    public void updateReservation(ReservationRequest reservationRequest, int id) {
        ReservationEntity reservationEntity = reservationsRepository.findById(id).orElse(null);
        if (reservationEntity == null) {
            throw new NotFoundException("Reservation not found");
        }

        reservationEntity.setStartTime(reservationRequest.getStartTime());
        reservationEntity.setEndTime(reservationRequest.getEndTime());
        reservationEntity.setPerson(personMapper.fromRequest(reservationRequest.getPerson()));
        reservationEntity.setItem(itemMapper.fromRequest(reservationRequest.getItem()));

        reservationsRepository.save(reservationEntity);
    }

    public void deleteReservation(int id) {
        ReservationEntity reservationEntity = reservationsRepository.findById(id).orElse(null);
        if (reservationEntity == null) {
            throw new NotFoundException("Reservation not found");
        }
        reservationsRepository.delete(reservationEntity);
    }
}
