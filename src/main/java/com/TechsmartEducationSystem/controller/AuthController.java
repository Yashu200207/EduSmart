package com.TechsmartEducationSystem.controller;

import com.TechsmartEducationSystem.model.User;
import com.TechsmartEducationSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if(userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        return userRepository.findByUsername(user.getUsername())
                .map(u -> {
                    if(passwordEncoder.matches(user.getPassword(), u.getPassword())) {
                        return ResponseEntity.ok("Login successful");
                    } else {
                        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid username or password");
                    }
                })
                .orElse(ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid username or password"));
    }
}
