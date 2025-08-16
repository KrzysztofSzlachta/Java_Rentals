package com.szlachta.rentals.dto;

import com.szlachta.rentals.models.PersonEntity;
import com.szlachta.rentals.validators.IsPeselOrDocument;
import com.szlachta.rentals.validators.UniqueValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;

@SuppressWarnings("unused")
@IsPeselOrDocument
public class PersonRequest {
    @NotBlank( message = "to pole jest wymagane" )
    @Size(min = 3, max = 20, message = "imię musi mieć od 3 do 20 znaków")
    private String firstName;
    @NotBlank( message = "to pole jest wymagane" )
    @Size(min = 3, max = 20, message = "nazwisko musi mieć od 3 do 20 znaków")
    private String lastName;
    @Size(min = 11, max = 11, message = "pesel musi mieć od 3 do 20 znaków")
    @UniqueValue(entity = PersonEntity.class, field = "pesel", message = "osoba o takim peselu jest już zarejestrowana")
    private String pesel;
    @Size(min = 3, max = 20, message = "numer dokumentu musi mieć od 3 do 20 znaków")
    @UniqueValue(entity = PersonEntity.class, field = "documentNumber",
            message = "Osoba z takim numerem dokumentu jest już zarejestrowana")
    private String documentNumber;
    @Size(min = 3, max = 20, message = "typ dokumentu musi mieć od 3 do 20 znaków")
    private String documentType;
    //@NotBlank(message = "to pole jest wymagane")
    private LocalDate birthDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
