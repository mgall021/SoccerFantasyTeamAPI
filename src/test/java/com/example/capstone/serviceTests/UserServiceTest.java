package com.example.capstone.serviceTests;

import com.example.capstone.repository.UserRepository;
import com.example.capstone.service.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
}
