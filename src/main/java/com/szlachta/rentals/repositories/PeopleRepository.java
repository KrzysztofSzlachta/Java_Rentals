package com.szlachta.rentals.repositories;

import com.szlachta.rentals.models.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<PersonEntity, Integer> {
    boolean existsByDocumentNumber(String documentNumber);
    boolean existsByPesel(String pesel);

    boolean existsByPeselAndIdNot(String pesel, Integer id);
    boolean existsByDocumentNumberAndIdNot(String documentNumber, Integer id);
}
