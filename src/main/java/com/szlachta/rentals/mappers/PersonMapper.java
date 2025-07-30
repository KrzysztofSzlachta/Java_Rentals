package com.szlachta.rentals.mappers;

import com.szlachta.rentals.dto.PersonResponse;
import com.szlachta.rentals.models.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public PersonResponse fromEntity(PersonEntity personEntity) {
        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getId());
        personResponse.setFirstName(personEntity.getFirstName());
        personResponse.setLastName(personEntity.getLastName());

        return personResponse;
    }
}
