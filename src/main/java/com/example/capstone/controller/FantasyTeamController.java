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

    @GetMapping("/{userId}")
    public ResponseEntity<List<FantasyTeam>> getUserFantasyTeams(@PathVariable Long userId) {
        return ResponseEntity.ok(fantasyTeamService.getUserFantasyTeams(userId));
    }

    @PostMapping
    public ResponseEntity<FantasyTeam> createFantasyTeam(@RequestBody FantasyTeam fantasyTeam) {
        return ResponseEntity.ok(fantasyTeamService.createFantasyTeam(fantasyTeam));
    }

    @PutMapping("/{teamId}/addPlayer/{playerId}")
    public ResponseEntity<FantasyTeam> addPlayerToTeam(@PathVariable Long teamId, @PathVariable Long playerId) {
        return ResponseEntity.ok(fantasyTeamService.addPlayerToTeam(teamId, playerId));
    }

    @PutMapping("/{teamId}/removePlayer/{playerId}")
    public ResponseEntity<FantasyTeam> removePlayerFromTeam(@PathVariable Long teamId, @PathVariable Long playerId) {
        return ResponseEntity.ok(fantasyTeamService.removePlayerFromTeam(teamId, playerId));
    }
    @DeleteMapping("/{teamId}")
    public ResponseEntity<Void> deleteFantasyTeam(@PathVariable Long teamId) {
        fantasyTeamService.deleteFantasyTeam(teamId);
        return ResponseEntity.noContent().build();
    }
}
