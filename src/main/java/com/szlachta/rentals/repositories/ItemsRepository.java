package com.szlachta.rentals.repositories;

import com.szlachta.rentals.models.ItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemsRepository extends CrudRepository<ItemEntity, Integer> {
    Optional<ItemEntity> findByIdAndDeletedIsFalse(Integer id);
}
