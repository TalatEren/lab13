package com.talatdaylan.lab13.service;

import com.talatdaylan.lab13.model.User;
import com.talatdaylan.lab13.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        
        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
