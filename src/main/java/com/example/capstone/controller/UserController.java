package com.example.capstone.controller;

import com.example.capstone.model.User;
import com.example.capstone.model.request.LoginRequest;
import com.example.capstone.model.response.LoginResponse;
import com.example.capstone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/auth/users")
public class UserController {
    private final UserService userService;
    HashMap<String, Object > response = new HashMap<>();
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register/")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        response.put("message", "success");
        response.put("data", createdUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login/")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest){
        Optional<String> jwtToken = userService.loginUser(loginRequest);
        if (jwtToken.isPresent()){
            return ResponseEntity.ok(new LoginResponse(jwtToken.get()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Authentication failed"));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        // Check if the user exists
        Optional<User> existingUser = userService.getUserById(userId);
        if (existingUser.isPresent()) {
            User updated = userService.updateUser(userId, updatedUser);
            response.put("message", "success");
            response.put("data", updated);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // Handle the case where the user with the given ID doesn't exist
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userId}/")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        User user = userService.deleteUser(userId);
        response.put("message","deleted successfully");
        response.put("data",user);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
