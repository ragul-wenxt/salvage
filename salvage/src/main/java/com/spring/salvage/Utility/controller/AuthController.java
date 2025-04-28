package com.spring.salvage.Utility.controller;

import com.spring.salvage.Utility.model.AuthRequest;
import com.spring.salvage.Utility.model.AuthResponse;
import com.spring.salvage.Utility.model.User;
import com.spring.salvage.Utility.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}