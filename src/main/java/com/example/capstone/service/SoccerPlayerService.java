package com.example.capstone.service;

import com.example.capstone.model.SoccerPlayer;
import com.example.capstone.repository.SoccerPlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoccerPlayerService {

    private SoccerPlayerRepository soccerPlayerRepository;

    private final List<SoccerPlayer> soccerPlayersList;

    public SoccerPlayerService(SoccerPlayerRepository soccerPlayerRepository, List<SoccerPlayer> soccerPlayersList) {
        this.soccerPlayerRepository = soccerPlayerRepository;
        this.soccerPlayersList = soccerPlayersList;
    }

    public List<SoccerPlayer> getAllSoccerPlayers() {
        return soccerPlayerRepository.findAll(); // Return the list of soccer players
    }

    public List<SoccerPlayer> getSoccerPlayersByName(String name) {
        return soccerPlayerRepository.findByName(name);
    }

    public SoccerPlayer getSoccerPlayerById(Long id) {
        return soccerPlayerRepository.findById(id).orElse(null);
    }

    public List<SoccerPlayer> getSoccerPlayerByCountry(String country) {
        return soccerPlayerRepository.findByCountry(country);
    }

    public List<SoccerPlayer> getSoccerPlayerByPosition(String position) {
        return soccerPlayerRepository.findByPosition(position);
    }

    public List<SoccerPlayer> getSoccerPlayerByTeam(String team) {
        return soccerPlayerRepository.findByTeam(team);
    }




}
