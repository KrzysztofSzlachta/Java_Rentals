package com.szlachta.rentals.services;

import com.szlachta.rentals.dto.ReservationRequest;
import com.szlachta.rentals.dto.ReservationResponse;
import com.szlachta.rentals.dto.SearchByItemReservationResponse;
import com.szlachta.rentals.dto.SearchByPersonReservationResponse;
import com.szlachta.rentals.exceptions.BadRequestException;
import com.szlachta.rentals.exceptions.NotFoundException;
import com.szlachta.rentals.exceptions.ConflictException;
import com.szlachta.rentals.mappers.ItemMapper;
import com.szlachta.rentals.mappers.PersonMapper;
import com.szlachta.rentals.mappers.ReservationMapper;
import com.szlachta.rentals.models.ReservationEntity;
import com.szlachta.rentals.repositories.ItemsRepository;
import com.szlachta.rentals.repositories.PeopleRepository;
import com.szlachta.rentals.repositories.ReservationsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
            throw new NotFoundException("Rezerwacja nie znaleziona");
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
        LocalDateTime startTime = reservationRequest.getStartTime();
        LocalDateTime endTime = reservationRequest.getEndTime();

        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setPerson(peopleRepository.findByIdAndDeletedIsFalse(idPerson).orElseThrow(()
                -> new NotFoundException("Osoba nie znaleziona")));
        reservationEntity.setItem(itemsRepository.findByIdAndDeletedIsFalse(idItem).orElseThrow(()
                -> new NotFoundException("Przedmiot nie znaleziony")));
        if (reservationsRepository.existsByItemIdAndStartTimeIsBeforeAndEndTimeIsAfter(idItem, startTime, endTime)) {
            throw new ConflictException("Przedmiot zarezerwowany. Spóbuj innej daty");
        }
        if (endTime.isBefore(startTime)) {
            throw new BadRequestException("Rezerwacja musi się kończyć po tym, jak się zaczyna");
        }
        if (reservationsRepository.existsByItemIdAndStartTimeIsBetween(idItem, startTime, endTime)) {
            throw new ConflictException("Przedmiot zarezerwowany. Spróbuj wcześniejszej daty");
        }
        if (reservationsRepository.existsByItemIdAndEndTimeIsBetween(idItem, startTime, endTime)) {
            throw new ConflictException("Przedmiot zarezerwowany. Spróbuj późniejszej daty");
        }

        reservationEntity.setStartTime(startTime);
        reservationEntity.setEndTime(endTime);

        reservationsRepository.save(reservationEntity);
    }

    public void updateReservation(ReservationRequest reservationRequest, int idReservation, int idPerson, int idItem) {
        ReservationEntity reservationEntity = reservationsRepository.findById(idReservation).orElse(null);
        if (reservationEntity == null) {
            throw new NotFoundException("Rezerwacja nie znaleziona");
        }
        LocalDateTime startTime = reservationRequest.getStartTime();
        LocalDateTime endTime = reservationRequest.getEndTime();

        reservationEntity.setPerson(peopleRepository.findByIdAndDeletedIsFalse(idPerson).orElseThrow(()
                -> new NotFoundException("Osoba nie znaleziona")));
        reservationEntity.setItem(itemsRepository.findByIdAndDeletedIsFalse(idItem).orElseThrow(()
                -> new NotFoundException("Przedmiot nie znaleziony")));
        if (reservationsRepository.existsByItemIdAndStartTimeIsBeforeAndEndTimeIsAfter(idItem, startTime, endTime)) {
            throw new ConflictException("Przedmiot zarezerwowany. Spóbuj innej daty");
        }
        if (endTime.isBefore(startTime)) {
            throw new BadRequestException("Rezerwacja musi się kończyć po tym, jak się zaczyna");
        }
        if (reservationsRepository.existsByItemIdAndStartTimeIsBetween(idItem, startTime, endTime)) {
            throw new ConflictException("Przedmiot zarezerwowany. Spróbuj wcześniejszej daty");
        }
        if (reservationsRepository.existsByItemIdAndEndTimeIsBetween(idItem, startTime, endTime)) {
            throw new ConflictException("Przedmiot zarezerwowany. Spróbuj późniejszej daty");
        }

        reservationEntity.setStartTime(startTime);
        reservationEntity.setEndTime(endTime);

        reservationsRepository.save(reservationEntity);
    }

    public void deleteReservation(int id) {
        ReservationEntity reservationEntity = reservationsRepository.findById(id).orElse(null);
        if (reservationEntity == null) {
            throw new NotFoundException("Rezerwacja nie znaleziona");
        }
        reservationsRepository.delete(reservationEntity);
    }

    public List<SearchByPersonReservationResponse> getReservationsByPerson(int idPerson) {
        List<ReservationEntity> reservationEntities = reservationsRepository.findByPersonId(idPerson);
        List<SearchByPersonReservationResponse> searchByPersonReservationResponses = new ArrayList<>();
        for (ReservationEntity reservationEntity : reservationEntities) {
            searchByPersonReservationResponses.add(reservationMapper.searchByPersonFromEntity(reservationEntity));
        }
        return searchByPersonReservationResponses;
    }

    public List<SearchByItemReservationResponse> getReservationsByItem(int idItem) {
        List<ReservationEntity> reservationEntities = reservationsRepository.findByItemId(idItem);
        List<SearchByItemReservationResponse> searchByItemReservationResponses = new ArrayList<>();
        for (ReservationEntity reservationEntity : reservationEntities) {
            searchByItemReservationResponses.add(reservationMapper.searchByItemFromEntity(reservationEntity));
        }
        return searchByItemReservationResponses;
    }
}
