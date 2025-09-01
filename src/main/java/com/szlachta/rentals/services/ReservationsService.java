package com.szlachta.rentals.services;

import com.szlachta.rentals.dto.ReservationRequest;
import com.szlachta.rentals.dto.ReservationResponse;
import com.szlachta.rentals.exceptions.NotFoundException;
import com.szlachta.rentals.mappers.ItemMapper;
import com.szlachta.rentals.mappers.PersonMapper;
import com.szlachta.rentals.mappers.ReservationMapper;
import com.szlachta.rentals.models.ItemEntity;
import com.szlachta.rentals.models.PersonEntity;
import com.szlachta.rentals.models.ReservationEntity;
import com.szlachta.rentals.repositories.ItemsRepository;
import com.szlachta.rentals.repositories.PeopleRepository;
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
    private final PeopleRepository peopleRepository;
    private final ItemsRepository itemsRepository;

    public ReservationsService(ReservationsRepository reservationsRepository, ReservationMapper reservationMapper, PeopleRepository peopleRepository, ItemsRepository itemsRepository) {
        this.reservationsRepository = reservationsRepository;
        this.reservationMapper = reservationMapper;
        this.personMapper = new PersonMapper();
        this.itemMapper = new ItemMapper();
        this.peopleRepository = peopleRepository;
        this.itemsRepository = itemsRepository;
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

    public void createReservation(ReservationRequest reservationRequest, int idPerson, int idItem) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setPerson(peopleRepository.findById(idPerson).orElse(null));
        reservationEntity.setItem(itemsRepository.findById(idItem).orElse(null));
        reservationEntity.setStartTime(reservationRequest.getStartTime());
        reservationEntity.setEndTime(reservationRequest.getEndTime());

        reservationsRepository.save(reservationEntity);
    }

    public void updateReservation(ReservationRequest reservationRequest, int idReservation, int idPerson, int idItem) {
        ReservationEntity reservationEntity = reservationsRepository.findById(idReservation).orElse(null);
        if (reservationEntity == null) {
            throw new NotFoundException("Reservation not found");
        }

        reservationEntity.setStartTime(reservationRequest.getStartTime());
        reservationEntity.setEndTime(reservationRequest.getEndTime());
        reservationEntity.setPerson(peopleRepository.findById(idPerson).orElseThrow(()
                -> new NotFoundException("Person not found")));
        reservationEntity.setItem(itemsRepository.findById(idItem).orElseThrow(()
                -> new NotFoundException("Item not found")));

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
