package com.example.capstone.serviceTests;


import com.example.capstone.repository.FantasyTeamRepository;
import com.example.capstone.repository.SoccerPlayerRepository;
import com.example.capstone.service.FantasyTeamService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class FantasyTeamServiceTest {
    @InjectMocks
    private FantasyTeamService fantasyTeamService;

    @Mock
    private FantasyTeamRepository fantasyTeamRepository;

    @Mock
    private SoccerPlayerRepository soccerPlayerRepository;

}
