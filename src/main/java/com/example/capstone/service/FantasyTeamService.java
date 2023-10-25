package com.example.capstone.service;

import com.example.capstone.model.FantasyTeam;
import com.example.capstone.model.SoccerPlayer;
import com.example.capstone.repository.FantasyTeamRepository;
import com.example.capstone.repository.SoccerPlayerRepository;
import com.example.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class FantasyTeamService {
    @Autowired
    private FantasyTeamRepository fantasyTeamRepository;

    @Autowired
    private  SoccerPlayerRepository soccerPlayerRepository;

    private final Logger logger = Logger.getLogger(FantasyTeamService.class.getName());


    public List<FantasyTeam> getUserFantasyTeams(Long userId) {
        return fantasyTeamRepository.findByUser_Id(userId);
    }

    public FantasyTeam createFantasyTeam(FantasyTeam fantasyTeam) {
        if (fantasyTeam.getSoccerPlayers().size() > 11) {
            throw new IllegalArgumentException("A fantasy team can have at most 11 players.");
        }
        return fantasyTeamRepository.save(fantasyTeam);
    }

    public FantasyTeam addPlayerToTeam(Long teamId, Long playerId) {
        FantasyTeam fantasyTeam = fantasyTeamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException("Fantasy team not found."));

        SoccerPlayer player = soccerPlayerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player not found."));

        if (fantasyTeam.getSoccerPlayers().size() >= 11) {
            throw new IllegalArgumentException("A fantasy team can have at most 11 players.");
        }

        fantasyTeam.getSoccerPlayers().add(player);
        return fantasyTeamRepository.save(fantasyTeam);
    }

}
