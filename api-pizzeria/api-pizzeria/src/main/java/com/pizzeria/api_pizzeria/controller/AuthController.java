package com.pizzeria.api_pizzeria.controller;

import com.pizzeria.api_pizzeria.dto.EmpleadoRequestDTO;
import com.pizzeria.api_pizzeria.dto.LoginRequest;
import com.pizzeria.api_pizzeria.dto.LoginResponse;
import com.pizzeria.api_pizzeria.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(
            @Valid @RequestBody EmpleadoRequestDTO request) {

        return ResponseEntity.ok(
                authService.register(request)
        );
    }
}
