package com.szlachta.rentals.repositories;

import com.szlachta.rentals.models.ReservationEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReservationsRepository extends CrudRepository<ReservationEntity, Integer> {

}
