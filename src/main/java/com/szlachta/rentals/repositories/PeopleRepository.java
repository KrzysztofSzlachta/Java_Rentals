package com.szlachta.rentals.repositories;

import com.szlachta.rentals.models.PersonEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PeopleRepository extends CrudRepository<PersonEntity, Integer> {
    boolean existsByDocumentNumberAndDeletedIsTrue(String documentNumber);
    boolean existsByPeselAndDeletedIsTrue(String pesel);

    boolean existsByPeselAndIdNotAndDeletedIsFalse(String pesel, Integer id);
    boolean existsByDocumentNumberAndIdNotAndDeletedIsFalse(String documentNumber, Integer id);

    List<PersonEntity> findByIdIn(List<Integer> ids);

    Optional<PersonEntity> findByIdAndDeletedIsFalse(Integer id);
}
