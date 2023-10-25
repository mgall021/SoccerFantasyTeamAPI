package com.example.capstone.serviceTests;


import com.example.capstone.repository.FantasyTeamRepository;
import com.example.capstone.repository.SoccerPlayerRepository;
import com.example.capstone.service.FantasyTeamService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FantasyTeamServiceTest {
    @InjectMocks
    private FantasyTeamService fantasyTeamService;

    @Mock
    private FantasyTeamRepository fantasyTeamRepository;

    @Mock
    private SoccerPlayerRepository soccerPlayerRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

}
