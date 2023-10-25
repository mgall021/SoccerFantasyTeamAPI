package com.example.capstone.controller;

import com.example.capstone.service.FantasyTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fantasyTeam")
public class FantasyTeamController {
    @Autowired
    private FantasyTeamService fantasyTeamService;

}
