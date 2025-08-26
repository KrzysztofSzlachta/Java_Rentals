package com.szlachta.rentals.repositories;

import com.szlachta.rentals.models.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<PersonEntity, Integer> {
    boolean existsByPesel(String pesel);
    boolean existsByDocumentNumber(String documentNumber);
}
