package com.example.capstone.serviceTests;

import com.example.capstone.model.User;
import com.example.capstone.repository.UserRepository;
import com.example.capstone.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    Long userId = 1L;

    @BeforeEach // Initializes Mockito annotations before each test method.
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserById(){
        User user = new User(1L, "Marco", "marco@example.com", "password123");
        // Call the UserRepository to return the user when findById is called
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        // Call the getUserById method to retrieve a user by their ID
        Optional<User> result = userService.getUserById(userId);
        verify(userRepository, times(1)).findById(userId);
        assertTrue(result.isPresent());
        assertEquals("Marco", result.get().getName());
        assertEquals("marco@example.com",result.get().getEmailAddress());
    }

    @Test
    public void testGetUserByIdNotFound() {
        Long userId = 77L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        Optional<User> result = userService.getUserById(userId);

        verify(userRepository, times(1)).findById(userId);
        assertFalse(result.isPresent());
    }

    @Test
    public void testCreateUser() { // will not pass bc it needs password authentication
        User userToCreate = new User(userId, "Whitney", "pink@gmail.com", "newpassword456");
        when(userRepository.save(userToCreate)).thenReturn(userToCreate);
        User createdUser = userService.createUser(userToCreate);

        verify(userRepository, times(1)).save(userToCreate);
        assertNotNull(createdUser.getId());
        assertEquals("Whitney", createdUser.getName());
        assertEquals("pink@gmail.com", createdUser.getEmailAddress());
    }




}
