package com.szlachta.rentals.services;

import com.szlachta.rentals.dto.PersonRequest;
import com.szlachta.rentals.dto.PersonResponse;
import com.szlachta.rentals.exceptions.NotFoundException;
import com.szlachta.rentals.mappers.PersonMapper;
import com.szlachta.rentals.models.PersonEntity;
import com.szlachta.rentals.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;
    private final PersonMapper personMapper;

    public PeopleService(PeopleRepository peopleRepository, PersonMapper personMapper) {
        this.peopleRepository = peopleRepository;
        this.personMapper = personMapper;
    }

    public PersonResponse getPersonById(int id) {
        PersonEntity personEntity = peopleRepository.findById(id).orElse(null);
        if (personEntity == null) {
            throw new NotFoundException("Person not found");
        }
        return personMapper.fromEntity(personEntity);
    }

    public List<PersonResponse> getPeople() {
        Iterable<PersonEntity> peopleEntities = peopleRepository.findAll();
        List<PersonResponse> peopleResponses = new ArrayList<>();
        for (PersonEntity personEntity : peopleEntities) {
            peopleResponses.add(personMapper.fromEntity(personEntity));
        }
        return peopleResponses;
    }

    public void createPerson(PersonRequest personRequest) {
        peopleRepository.save(personMapper.fromRequest(personRequest));
    }

    public void updatePerson(PersonRequest personRequest, int id) {
        PersonEntity personEntity = peopleRepository.findById(id).orElse(null);
        if (personEntity == null) {
            throw new NotFoundException("Person not found");
        }
        personEntity.setFirstName(personRequest.getFirstName());
        personEntity.setLastName(personRequest.getLastName());
        personEntity.setPesel(personRequest.getPesel());
        personEntity.setDocumentNumber(personRequest.getDocumentNumber());
        personEntity.setDocumentType(personRequest.getDocumentType());
        personEntity.setBirthDate(personRequest.getBirthDate());

        peopleRepository.save(personEntity);
    }

    public void deletePerson(int id) {
        System.out.println(id);
    }
}
