package com.TechsmartEducationSystem.util;


import com.TechsmartEducationSystem.repository.UserRepository;
import com.TechsmartEducationSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FixPasswords implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            String pwd = user.getPassword();
            if (!pwd.startsWith("$2a$")) { // Not hashed
                String hashed = passwordEncoder.encode(pwd);
                user.setPassword(hashed);
                userRepository.save(user);
                System.out.println("Updated password for: " + user.getUsername());
            }
        }

        System.out.println("All plain-text passwords fixed!");
    }
}
