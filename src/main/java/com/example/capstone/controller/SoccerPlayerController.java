package com.example.capstone.controller;

import com.example.capstone.model.SoccerPlayer;
import com.example.capstone.service.SoccerPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/api/soccerplayers")
public class SoccerPlayerController {
    private final SoccerPlayerService soccerPlayerService;

    @Autowired
    public SoccerPlayerController(SoccerPlayerService soccerPlayerService) {
        this.soccerPlayerService = soccerPlayerService;
    }

    @GetMapping
    public ResponseEntity<?> getAllSoccerPlayers() {
        List<SoccerPlayer> soccerPlayersList = soccerPlayerService.getAllSoccerPlayers();
        HashMap<String, Object> message = new HashMap<>();

        if (soccerPlayersList.isEmpty()) {
            message.put("message", "Cannot find any soccer players.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            message.put("message", "Success");
            message.put("data", soccerPlayersList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<?> getSoccerPlayersByName(@PathVariable String name) {
        List<SoccerPlayer> soccerPlayersList = soccerPlayerService.getSoccerPlayersByName(name);
        HashMap<String, Object> message = new HashMap<>();

        if (soccerPlayersList.isEmpty()) {
            message.put("message", "Cannot find any soccer players with the given name.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            message.put("message", "Success");
            message.put("data", soccerPlayersList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getSoccerPlayerById(@PathVariable Long id) {
        SoccerPlayer soccerPlayer = soccerPlayerService.getSoccerPlayerById(id);
        HashMap<String, Object> message = new HashMap<>();
        if (soccerPlayer == null) {
            message.put("message", "Cannot find the soccer player with the given ID.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            message.put("message", "Success");
            message.put("data", soccerPlayer);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<?> getSoccerPlayerByCountry(@PathVariable String country) {
        List<SoccerPlayer> soccerPlayers = soccerPlayerService.getSoccerPlayerByCountry(country);
        HashMap<String, Object> message = new HashMap<>();
        if (soccerPlayers.isEmpty()) {
            message.put("message", "Cannot find soccer players from the specified country.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            message.put("message", "Success");
            message.put("data", soccerPlayers);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }






}
