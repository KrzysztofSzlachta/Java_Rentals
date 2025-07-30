package com.szlachta.rentals.controllers;

import com.szlachta.rentals.dto.PersonRequest;
import com.szlachta.rentals.dto.PersonResponse;
import com.szlachta.rentals.services.PeopleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/{id}")
    public PersonResponse getPerson(@PathVariable int id) {
        return peopleService.getPersonById(id);
    }

    @PostMapping
    public void createPerson(@RequestBody @Valid PersonRequest personRequest) {
        peopleService.createPerson(personRequest);
    }

    @PutMapping("/{id}")
    public void updatePerson(@RequestBody @Valid PersonRequest personRequest, @PathVariable int id) {
        peopleService.updatePerson(personRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) {
        peopleService.deletePerson(id);
    }

}
