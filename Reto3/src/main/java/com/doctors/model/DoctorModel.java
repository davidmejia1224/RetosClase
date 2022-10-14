package com.doctors.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "doctor")
public class DoctorModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "department", nullable = false, length = 45)
    private String department;
    @Column(name = "year", nullable = false, length = 4)
    private Integer year;

    private String description;
    @ManyToOne
    @JoinColumn(name = "specialtyId")
    @JsonIgnoreProperties("doctors")
    private SpecialtyModel specialty;
    //{doctor,client}
    @OneToMany(mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "client"})
    private List<MessageModel> messages;
    @OneToMany(mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "client"})
    private List<ReservationModel> reservations;
    public DoctorModel() {
    }

    public DoctorModel(Integer id, Integer year, String name, String description) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.description = description;
    }

    public DoctorModel(Integer year, String name, String description) {
        this.year = year;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SpecialtyModel getSpecialty() {
        return specialty;
    }

    public void setSpecialty(SpecialtyModel specialty) {
        this.specialty = specialty;
    }

    public List<MessageModel> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageModel> messages) {
        this.messages = messages;
    }

    public List<ReservationModel> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationModel> reservations) {
        this.reservations = reservations;
    }
}