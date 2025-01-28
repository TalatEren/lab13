package com.talatdaylan.lab13.controller;

import com.talatdaylan.lab13.model.User;
import com.talatdaylan.lab13.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = userService.authenticate(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile() {
        // To be implemented with security context
        return ResponseEntity.ok().build();
    }
}

class LoginRequest {
    private String email;
    private String password;

    // Getters and setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
