package com.example.capstone.seed;

import com.example.capstone.repository.FantasyTeamRepository;
import com.example.capstone.repository.SoccerPlayerRepository;
import com.example.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SeedData {
    private final FantasyTeamRepository fantasyTeamRepository;

    private final SoccerPlayerRepository soccerPlayerRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SeedData(FantasyTeamRepository fantasyTeamRepository, SoccerPlayerRepository soccerPlayerRepository, UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.fantasyTeamRepository = fantasyTeamRepository;
        this.soccerPlayerRepository = soccerPlayerRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
}
