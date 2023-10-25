package com.example.capstone.service;

import com.example.capstone.repository.FantasyTeamRepository;
import com.example.capstone.repository.SoccerPlayerRepository;
import com.example.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class FantasyTeamService {
    @Autowired
    private FantasyTeamRepository fantasyTeamRepository;

    @Autowired
    private  SoccerPlayerRepository soccerPlayerRepository;

    private final Logger logger = Logger.getLogger(FantasyTeamService.class.getName());


}
