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
    private String position;
    @Column
    private String team;
    @Column
    private String country;

    @Column
    private Double rating;
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

    public SoccerPlayer(Long id, String name, String position, Double rating, String team, String country) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.rating = rating;
        this.country=country;
        this.team=team;
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
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }


    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "SoccerPlayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                ", country='" + country + '\'' +
                ", rating=" + rating +
                ", fantasyTeams=" + fantasyTeams +
                '}';
    }

    public Set<FantasyTeam> getFantasyTeams() {
        return fantasyTeams;
    }

    public void setFantasyTeams(Set<FantasyTeam> fantasyTeams) {
        this.fantasyTeams = fantasyTeams;
    }
}
