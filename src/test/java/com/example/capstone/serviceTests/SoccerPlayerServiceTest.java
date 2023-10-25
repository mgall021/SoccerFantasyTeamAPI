package com.example.capstone.serviceTests;

import com.example.capstone.controller.SoccerPlayerController;
import com.example.capstone.service.SoccerPlayerService;
import com.nimbusds.jose.crypto.impl.AAD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SoccerPlayerServiceTest {
    @Autowired
    private SoccerPlayerService soccerPlayerService;
    @Autowired
    private SoccerPlayerController soccerPlayerController;


}
