package com.example.capstone.controller;

import com.example.capstone.service.SoccerPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/soccerplayers")
public class SoccerPlayerController {
    private final SoccerPlayerService soccerPlayerService;

    @Autowired
    public SoccerPlayerController(SoccerPlayerService soccerPlayerService) {
        this.soccerPlayerService = soccerPlayerService;
    }
}
