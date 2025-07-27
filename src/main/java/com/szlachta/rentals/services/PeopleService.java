package com.szlachta.rentals.services;

import com.szlachta.rentals.dto.PersonRequest;
import com.szlachta.rentals.dto.PersonResponse;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    public PersonResponse getPerson(int id) {
        return new PersonResponse();
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
