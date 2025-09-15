package com.szlachta.rentals.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "people")
public class PersonEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PeopleGenerator")
    @SequenceGenerator(name = "PeopleGenerator", sequenceName = "people_id_person_seq", allocationSize = 1)
    @Id
    @Column(name = "id_person")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String lastName;

    @Column
    private String pesel;

    // todo Change to Enum
    @Column(name = "document_nr")
    private String documentNumber;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column
    private boolean deleted;

    @OneToMany(mappedBy = "person")
    private List<ReservationEntity> reservations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationEntity> reservations) {
        this.reservations = reservations;
    }
}
