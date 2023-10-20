package com.example.capstone.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="soccerPlayers")
public class SoccerPlayer {

    private Long id;

    private String name;

    private String Position;

    private Double Rating;

    public SoccerPlayer(){

    }

    public SoccerPlayer(Long id, String name, String position, Double rating) {
        this.id = id;
        this.name = name;
        Position = position;
        Rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public Double getRating() {
        return Rating;
    }

    public void setRating(Double rating) {
        Rating = rating;
    }

    @Override
    public String toString() {
        return "SoccerPlayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Position='" + Position + '\'' +
                ", Rating=" + Rating +
                '}';
    }
}
