package com.example.capstone.controller;

import com.example.capstone.model.FantasyTeam;
import com.example.capstone.service.FantasyTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fantasyTeam")
public class FantasyTeamController {
    @Autowired
    private FantasyTeamService fantasyTeamService;

    @PostMapping
    public ResponseEntity<FantasyTeam> createFantasyTeam(@RequestBody FantasyTeam fantasyTeam) {
        return ResponseEntity.ok(fantasyTeamService.createFantasyTeam(fantasyTeam));
    }
}
