package com.example.capstone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="soccerPlayers")
public class SoccerPlayer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String Position;
    @Column
    private Double Rating;
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "soccerPlayers")
    @JsonIgnore
    private Set<FantasyTeam> fantasyTeams = new HashSet<>();

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

    public Set<FantasyTeam> getFantasyTeams() {
        return fantasyTeams;
    }

    public void setFantasyTeams(Set<FantasyTeam> fantasyTeams) {
        this.fantasyTeams = fantasyTeams;
    }
}
