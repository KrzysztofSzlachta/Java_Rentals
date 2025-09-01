package com.szlachta.rentals.services;

import com.szlachta.rentals.dto.PersonRequest;
import com.szlachta.rentals.dto.PersonResponse;
import com.szlachta.rentals.exceptions.NotFoundException;
import com.szlachta.rentals.exceptions.UniqueException;
import com.szlachta.rentals.mappers.PersonMapper;
import com.szlachta.rentals.models.PersonEntity;
import com.szlachta.rentals.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        String pesel = personRequest.getPesel();
        String documentNumber = personRequest.getDocumentNumber();
        boolean peselCheck = pesel != null && !pesel.isEmpty();
        boolean documentNumberCheck = documentNumber != null && !documentNumber.isEmpty();
        if(peselCheck && peopleRepository.existsByPesel(pesel)) {
            throw new UniqueException("Pesel jest już zarejestrowany");
        }
        if(documentNumberCheck && peopleRepository.existsByDocumentNumber(documentNumber)) {
            throw new UniqueException("DocumentNumber jest już zarejestrowany");
        }
        peopleRepository.save(personMapper.fromRequest(personRequest));
    }

    public void updatePerson(PersonRequest personRequest, int id) {
        PersonEntity personEntity = peopleRepository.findById(id).orElse(null);
        if (personEntity == null) {
            throw new NotFoundException("Person not found");
        }

        String pesel = personRequest.getPesel();
        String documentNumber = personRequest.getDocumentNumber();
        boolean peselCheck = pesel != null && !pesel.isEmpty();
        boolean documentNumberCheck = documentNumber != null && !documentNumber.isEmpty();
        if(peselCheck && peopleRepository.existsByPeselAndIdNot(pesel, id)) {
            throw new UniqueException("Pesel jest już zarejestrowany");
        }
        if(documentNumberCheck && peopleRepository.existsByDocumentNumberAndIdNot(documentNumber, id)) {
            throw new UniqueException("DocumentNumber jest już zarejestrowany");
        }
        personEntity.setFirstName(personRequest.getFirstName());
        personEntity.setLastName(personRequest.getLastName());
        personEntity.setPesel(pesel);
        personEntity.setDocumentNumber(documentNumber);
        personEntity.setDocumentType(personRequest.getDocumentType());
        personEntity.setBirthDate(personRequest.getBirthDate());

        peopleRepository.save(personEntity);
    }

    public void deletePerson(int id) {
        PersonEntity personEntity = peopleRepository.findById(id).orElse(null);
        if (personEntity == null) {
            throw new NotFoundException("Person not found");
        }

        personEntity.setFirstName("deleted");
        personEntity.setLastName("deleted");
        personEntity.setPesel(null);
        personEntity.setDocumentNumber(null);
        personEntity.setDocumentType("Deletion date:");
        personEntity.setBirthDate(LocalDate.now());
        personEntity.setDeleted(true);

        peopleRepository.save(personEntity);
    }
}
