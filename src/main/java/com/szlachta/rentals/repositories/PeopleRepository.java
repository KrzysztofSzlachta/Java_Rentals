package com.szlachta.rentals.repositories;

import com.szlachta.rentals.models.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<PersonEntity, Integer> {
    Iterable<PersonEntity> findAllByDeletedIsFalse(boolean deleted);
}
