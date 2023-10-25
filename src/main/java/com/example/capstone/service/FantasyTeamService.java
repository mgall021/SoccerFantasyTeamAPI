package com.example.capstone.service;

import com.example.capstone.repository.FantasyTeamRepository;
import com.example.capstone.repository.SoccerPlayerRepository;
import com.example.capstone.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FantasyTeamService {
    private final FantasyTeamRepository fantasyTeamRepository;

    private final UserRepository userRepository;

    private final SoccerPlayerRepository soccerPlayerRepository;

    public FantasyTeamService(FantasyTeamRepository fantasyTeamRepository, UserRepository userRepository, SoccerPlayerRepository soccerPlayerRepository) {
        this.fantasyTeamRepository = fantasyTeamRepository;
        this.userRepository = userRepository;
        this.soccerPlayerRepository = soccerPlayerRepository;
    }
}
