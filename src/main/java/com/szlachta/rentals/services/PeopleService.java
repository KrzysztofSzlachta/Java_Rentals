package com.szlachta.rentals.services;

import com.szlachta.rentals.dto.PersonRequest;
import com.szlachta.rentals.dto.PersonResponse;
import com.szlachta.rentals.exceptions.NotFoundException;
import com.szlachta.rentals.mappers.PersonMapper;
import com.szlachta.rentals.models.PersonEntity;
import com.szlachta.rentals.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

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

    public void createPerson(PersonRequest personRequest) {
        System.out.println("test");
    }

    public void updatePerson(PersonRequest personRequest, int id) {
        System.out.println(id);
    }

    public void deletePerson(int id) {
        System.out.println(id);
    }
}
