package com.szlachta.rentals.mappers;

import com.szlachta.rentals.dto.ReservationRequest;
import com.szlachta.rentals.dto.ReservationResponse;
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
