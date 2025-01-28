package com.talatdaylan.lab13.controller;

import com.talatdaylan.lab13.dto.AuthRequest;
import com.talatdaylan.lab13.dto.AuthResponse;
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
    public ResponseEntity<AuthResponse> register(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(convertToAuthResponse(createdUser));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        User user = userService.authenticate(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(convertToAuthResponse(user));
    }

    @GetMapping("/profile")
    public ResponseEntity<AuthResponse> getProfile() {
        User currentUser = userService.getCurrentUser();
        return ResponseEntity.ok(convertToAuthResponse(currentUser));
    }

    private AuthResponse convertToAuthResponse(User user) {
        return new AuthResponse(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getRole(),
            user.isActive()
        );
    }
}
