package com.szlachta.rentals.controllers;

import com.szlachta.rentals.dto.PersonRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PeopleController {
    @PostMapping
    public void createPerson(PersonRequest personRequest) {
        System.out.println("test");
    }
}
