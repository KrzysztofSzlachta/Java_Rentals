package com.szlachta.rentals.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class PersonRequest {
    @NotBlank( message = "to pole jest wymagane" )
    private String firstName;
    @NotBlank( message = "to pole jest wymagane" )
    private String lastName;
    private String pesel;
    private String documentNumber;
    private String documentType;
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
