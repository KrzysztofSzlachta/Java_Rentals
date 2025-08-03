package com.szlachta.rentals.mappers;

import com.szlachta.rentals.dto.PersonRequest;
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
        personResponse.setPesel(personEntity.getPesel());
        personResponse.setDocumentNumber(personEntity.getDocumentNumber());
        personResponse.setDocumentType(personEntity.getDocumentType());
        personResponse.setBirthDate(personEntity.getBirthDate());

        return personResponse;
    }

    public PersonEntity fromRequest(PersonRequest personRequest) {
        PersonEntity personEntity = new PersonEntity();

        personEntity.setFirstName(personRequest.getFirstName());
        personEntity.setLastName(personRequest.getLastName());
        personEntity.setPesel(personRequest.getPesel());
        personEntity.setDocumentNumber(personRequest.getDocumentNumber());
        personEntity.setDocumentType(personRequest.getDocumentType());
        personEntity.setBirthDate(personRequest.getBirthDate());

        return personEntity;
    }
}
