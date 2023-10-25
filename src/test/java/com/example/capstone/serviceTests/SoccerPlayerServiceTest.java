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

    @Test
    void testGetSoccerPlayersByName() {
        // Mocking the service method
        when(soccerPlayerService.getSoccerPlayersByName(anyString())).thenReturn(List.of(new SoccerPlayer()));

        ResponseEntity<?> response = soccerPlayerController.getSoccerPlayersByName("Name");


        @SuppressWarnings("unchecked")
        HashMap<String, Object> responseBody = (HashMap<String, Object>) response.getBody();
        @SuppressWarnings("unchecked")
        List<SoccerPlayer> returnedPlayers = (List<SoccerPlayer>) responseBody.get("data");

        assertEquals(1, returnedPlayers.size());
    }

    @Test
    void testGetSoccerPlayerById() {
        // Mock the service method
        SoccerPlayer mockPlayer = new SoccerPlayer();
        when(soccerPlayerService.getSoccerPlayerById(anyLong())).thenReturn(mockPlayer);

        // Call the controller method
        ResponseEntity<?> response = soccerPlayerController.getSoccerPlayerById(1L);

        // Extract the soccer player from the response
        @SuppressWarnings("unchecked")
        HashMap<String, Object> responseBody = (HashMap<String, Object>) response.getBody();
        SoccerPlayer returnedPlayer = (SoccerPlayer) responseBody.get("data");

        // Assert that the returned player matches the mock player
        assertEquals(mockPlayer, returnedPlayer);
    }

    @Test
    void testGetSoccerPlayerByCountry() {
        // Mock the service method
        SoccerPlayer mockPlayer1 = new SoccerPlayer();
        SoccerPlayer mockPlayer2 = new SoccerPlayer();
        when(soccerPlayerService.getSoccerPlayerByCountry(anyString())).thenReturn(List.of(mockPlayer1, mockPlayer2));

        ResponseEntity<?> response = soccerPlayerController.getSoccerPlayerByCountry("Brazil");


        @SuppressWarnings("unchecked")
        HashMap<String, Object> responseBody = (HashMap<String, Object>) response.getBody();
        @SuppressWarnings("unchecked")
        List<SoccerPlayer> returnedPlayers = (List<SoccerPlayer>) responseBody.get("data");


        assertEquals(2, returnedPlayers.size());
    }

    @Test
    void testGetSoccerPlayerByPosition() {

        SoccerPlayer mockPlayer1 = new SoccerPlayer();
        SoccerPlayer mockPlayer2 = new SoccerPlayer();
        when(soccerPlayerService.getSoccerPlayerByPosition(anyString())).thenReturn(List.of(mockPlayer1, mockPlayer2));
        ResponseEntity<?> response = soccerPlayerController.getSoccerPlayerByPosition("Midfielder");

        @SuppressWarnings("unchecked")
        HashMap<String, Object> responseBody = (HashMap<String, Object>) response.getBody();
        @SuppressWarnings("unchecked")
        List<SoccerPlayer> returnedPlayers = (List<SoccerPlayer>) responseBody.get("data");

        assertEquals(2, returnedPlayers.size());
    }











}
