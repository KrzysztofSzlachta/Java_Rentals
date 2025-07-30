package com.szlachta.rentals.repositories;

import com.szlachta.rentals.models.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemsRepository extends CrudRepository<ItemEntity, Integer> {
}
