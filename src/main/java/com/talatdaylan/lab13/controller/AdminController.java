package com.talatdaylan.lab13.controller;

import com.talatdaylan.lab13.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/users/{id}/activate")
    public ResponseEntity<?> activateUser(@PathVariable Long id) {
        // To be implemented
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users/{id}/deactivate")
    public ResponseEntity<?> deactivateUser(@PathVariable Long id) {
        // To be implemented
        return ResponseEntity.ok().build();
    }
}
