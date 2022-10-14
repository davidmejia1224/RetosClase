package com.doctors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class ScoreModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer score;
    @OneToOne
    @JsonIgnoreProperties("score")
    private ReservationModel reservations;

    public ScoreModel() {
    }

    public ScoreModel(Integer id, Integer score) {
        this.id = id;
        this.score = score;
    }

    public ScoreModel(Integer score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public ReservationModel getReservations() {
        return reservations;
    }

    public void setReservations(ReservationModel reservations) {
        this.reservations = reservations;
    }
}
