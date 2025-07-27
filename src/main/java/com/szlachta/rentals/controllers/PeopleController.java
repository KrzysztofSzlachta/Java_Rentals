package com.szlachta.rentals.controllers;

import com.szlachta.rentals.dto.PersonRequest;
import com.szlachta.rentals.dto.PersonResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PeopleController {

    @GetMapping("/{id}")
    public PersonResponse getPerson(@PathVariable int id) {
        return new PersonResponse();
    }

    @PostMapping
    public void createPerson(@RequestBody PersonRequest personRequest) {
        System.out.println("test");
    }

    @PutMapping("/{id}")
    public void updatePerson(@RequestBody PersonRequest personRequest, @PathVariable int id) {
        System.out.println(id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) {
        System.out.println(id);
    }

}
