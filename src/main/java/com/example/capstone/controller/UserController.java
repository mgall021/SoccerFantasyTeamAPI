package com.example.capstone.controller;

import com.example.capstone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/auth/users")
public class UserController {
    private final UserService userService;
    HashMap<String, Object > response = new HashMap<>();
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
