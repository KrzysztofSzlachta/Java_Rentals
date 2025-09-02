package com.szlachta.rentals.mappers;

import com.szlachta.rentals.dto.ReservationRequest;
import com.szlachta.rentals.dto.ReservationResponse;
import com.szlachta.rentals.dto.SearchByItemReservationResponse;
import com.szlachta.rentals.dto.SearchByPersonReservationResponse;
import com.szlachta.rentals.models.ReservationEntity;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    public ReservationResponse fromEntity(ReservationEntity reservationEntity){
        PersonMapper personMapper = new PersonMapper();
        ItemMapper itemMapper = new ItemMapper();
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setId(reservationEntity.getId());
        reservationResponse.setStartTime(reservationEntity.getStartTime());
        reservationResponse.setEndTime(reservationEntity.getEndTime());
        reservationResponse.setPerson(personMapper.fromEntity(reservationEntity.getPerson()));
        reservationResponse.setItem(itemMapper.fromEntity(reservationEntity.getItem()));

        return reservationResponse;
    }

    public SearchByPersonReservationResponse searchByPersonFromEntity(ReservationEntity reservationEntity){
        ItemMapper itemMapper = new ItemMapper();
        SearchByPersonReservationResponse searchByPersonReservationResponse = new SearchByPersonReservationResponse();
        searchByPersonReservationResponse.setId(reservationEntity.getId());
        searchByPersonReservationResponse.setStartTime(reservationEntity.getStartTime());
        searchByPersonReservationResponse.setEndTime(reservationEntity.getEndTime());
        searchByPersonReservationResponse.setItem(itemMapper.fromEntity(reservationEntity.getItem()));

        return searchByPersonReservationResponse;
    }

    public SearchByItemReservationResponse searchByItemFromEntity(ReservationEntity reservationEntity){
        PersonMapper personMapper = new PersonMapper();
        SearchByItemReservationResponse searchByItemReservationResponse = new SearchByItemReservationResponse();
        searchByItemReservationResponse.setId(reservationEntity.getId());
        searchByItemReservationResponse.setStartTime(reservationEntity.getStartTime());
        searchByItemReservationResponse.setEndTime(reservationEntity.getEndTime());
        searchByItemReservationResponse.setPerson(personMapper.fromEntity(reservationEntity.getPerson()));

        return searchByItemReservationResponse;
    }

    public ReservationEntity fromRequest(ReservationRequest reservationRequest){
        PersonMapper personMapper = new PersonMapper();
        ItemMapper itemMapper = new ItemMapper();
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setStartTime(reservationRequest.getStartTime());
        reservationEntity.setEndTime(reservationRequest.getEndTime());
        reservationEntity.setPerson(personMapper.fromRequest(reservationRequest.getPerson()));
        reservationEntity.setItem(itemMapper.fromRequest(reservationRequest.getItem()));

        return reservationEntity;
    }
}
