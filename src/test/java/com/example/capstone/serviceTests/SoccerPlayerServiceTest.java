package com.example.capstone.serviceTests;

import com.example.capstone.controller.SoccerPlayerController;
import com.example.capstone.model.SoccerPlayer;
import com.example.capstone.service.SoccerPlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SoccerPlayerServiceTest {
    @Mock
    private SoccerPlayerService soccerPlayerService;
    @Autowired
    private SoccerPlayerController soccerPlayerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        soccerPlayerController = new SoccerPlayerController(soccerPlayerService);
    }

    @Test
    void testGetAllSoccerPlayers() {
        // Mocking the service method
        when(soccerPlayerService.getAllSoccerPlayers()).thenReturn(List.of(new SoccerPlayer()));

        // Calling the controller method
        ResponseEntity<?> response = soccerPlayerController.getAllSoccerPlayers();

        // Extracting the soccer players list from the response
        @SuppressWarnings("unchecked")
        HashMap<String, Object> responseBody = (HashMap<String, Object>) response.getBody();
        @SuppressWarnings("unchecked")
        List<SoccerPlayer> returnedPlayers = (List<SoccerPlayer>) responseBody.get("data");

        // Asserting the size of the returned list
        assertEquals(1, returnedPlayers.size());
    }



}
