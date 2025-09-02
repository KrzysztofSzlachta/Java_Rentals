package com.szlachta.rentals.repositories;

import com.szlachta.rentals.models.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReservationsRepository extends CrudRepository<ReservationEntity, Integer> {
    List<ReservationEntity> findByPersonId(int personId);
    List<ReservationEntity> findByItemId(int itemId);
}
