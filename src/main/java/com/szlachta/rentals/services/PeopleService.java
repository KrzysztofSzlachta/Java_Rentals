package com.szlachta.rentals.services;

import com.szlachta.rentals.dto.PersonRequest;
import com.szlachta.rentals.dto.PersonResponse;
import com.szlachta.rentals.exceptions.NotFoundException;
import com.szlachta.rentals.models.PersonEntity;
import com.szlachta.rentals.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public PersonResponse getPerson(int id) {
        PersonEntity personEntity = peopleRepository.findById(id).orElse(null);
        if (personEntity == null) {
            throw new NotFoundException("Person not found");
        }
        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getId());
        personResponse.setFirstName(personEntity.getFirstName());
        personResponse.setLastName(personEntity.getLastName());

        return personResponse;
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
