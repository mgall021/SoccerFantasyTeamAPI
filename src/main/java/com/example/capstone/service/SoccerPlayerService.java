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
}
