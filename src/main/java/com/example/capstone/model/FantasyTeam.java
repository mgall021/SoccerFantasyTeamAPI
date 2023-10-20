package com.example.capstone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "fantasyTeams")
public class FantasyTeam {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
   @JoinTable(name = "fantasyTeam_soccerPlayers",
      joinColumns = { @JoinColumn (name = "fantasyTeam_id")},
       inverseJoinColumns = {@JoinColumn(name="soccerPlayers_id")})
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<SoccerPlayer> soccerPlayers = new HashSet<>();

    public FantasyTeam(Long id, String name, User user, Set<SoccerPlayer> soccerPlayers) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.soccerPlayers = soccerPlayers;
    }

    public FantasyTeam() {

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
