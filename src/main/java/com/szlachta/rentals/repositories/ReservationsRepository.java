package com.szlachta.rentals.repositories;

import com.szlachta.rentals.models.ReservationEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationsRepository extends CrudRepository<ReservationEntity, Integer> {
    List<ReservationEntity> findByPersonId(int id);
    List<ReservationEntity> findByPersonIdAndEndTimeIsAfter(int personId, LocalDateTime endTime);
    List<ReservationEntity> findByItemId(int itemId);
    List<ReservationEntity> findByItemIdAndEndTimeIsAfter(int itemId, LocalDateTime endTime);
    boolean existsByItemIdAndEndTimeIsBetween(int itemId, LocalDateTime start, LocalDateTime end);
    boolean existsByItemIdAndStartTimeIsBetween(int itemId, LocalDateTime startTime, LocalDateTime endTime);
    boolean existsByItemIdAndStartTimeIsBeforeAndEndTimeIsAfter
            (int itemId, LocalDateTime startTime, LocalDateTime endTime);
    boolean existsByPersonIdAndEndTimeIsBefore(int personId, LocalDateTime endTime);
}
