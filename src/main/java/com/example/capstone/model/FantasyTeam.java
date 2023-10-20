package com.example.capstone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

public class FantasyTeam {
    private Long id;

    private String name;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    private Set<SoccerPlayer> soccerPlayers = new HashSet<>();

    public FantasyTeam(Long id, String name, User user, Set<SoccerPlayer> soccerPlayers) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.soccerPlayers = soccerPlayers;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<SoccerPlayer> getSoccerPlayers() {
        return soccerPlayers;
    }

    public void setSoccerPlayers(Set<SoccerPlayer> soccerPlayers) {
        this.soccerPlayers = soccerPlayers;
    }

    @Override
    public String toString() {
        return "FantasyTeam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", soccerPlayers=" + soccerPlayers +
                '}';
    }
}
