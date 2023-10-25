package com.example.capstone.serviceTests;


import com.example.capstone.model.FantasyTeam;
import com.example.capstone.repository.FantasyTeamRepository;
import com.example.capstone.repository.SoccerPlayerRepository;
import com.example.capstone.service.FantasyTeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

    @Test
    public void testCreateFantasyTeam() {
        FantasyTeam team = new FantasyTeam();
        when(fantasyTeamRepository.save(any(FantasyTeam.class))).thenReturn(team);

        FantasyTeam result = fantasyTeamService.createFantasyTeam(team);
        assertEquals(result, team);
    }


}
