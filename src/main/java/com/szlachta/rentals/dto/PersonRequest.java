package com.szlachta.rentals.dto;

import jakarta.validation.constraints.NotBlank;

@SuppressWarnings("unused")
public class PersonRequest {
    @NotBlank( message = "to pole jest wymagane" )
    private String firstName;
    @NotBlank( message = "to pole jest wymagane" )
    private String lastName;
    @NotBlank( message = "to pole jest wymagane" )
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
