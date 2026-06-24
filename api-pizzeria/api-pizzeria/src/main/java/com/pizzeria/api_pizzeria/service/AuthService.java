package com.pizzeria.api_pizzeria.service;

import com.pizzeria.api_pizzeria.dto.EmpleadoRequestDTO;
import com.pizzeria.api_pizzeria.dto.LoginRequest;
import com.pizzeria.api_pizzeria.dto.LoginResponse;
import com.pizzeria.api_pizzeria.model.Empleado;
import com.pizzeria.api_pizzeria.repository.EmpleadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {
    private EmpleadoRepository empleadoRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(EmpleadoRepository empleadoRepository, PasswordEncoder passwordEncoder) {
        this.empleadoRepository = empleadoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(LoginRequest request) {
        Empleado empleado = empleadoRepository.findByDni(request.getDni())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales invalidas"));

        if (!passwordEncoder.matches(request.getPassword(), empleado.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales invalidas");
        }

        return LoginResponse.builder()
                .dni(empleado.getDni())
                .nombre(empleado.getNombre())
                .mensaje("Login exitoso")
                .cargo(empleado.getCargo().name())
                .build();
    }

    public LoginResponse register(EmpleadoRequestDTO request) {

        if (empleadoRepository.existsByDni(request.getDni())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El DNI ya se encuentra registrado"
            );
        }

        Empleado empleado = new Empleado();

        empleado.setNombre(request.getNombre());
        empleado.setDni(request.getDni());
        empleado.setPassword(
                passwordEncoder.encode(request.getPassword())
        );
        empleado.setTelefono(request.getTelefono());
        empleado.setCargo(request.getCargo());

        Empleado empleadoGuardado = empleadoRepository.save(empleado);

        return LoginResponse.builder()
                .dni(empleadoGuardado.getDni())
                .nombre(empleadoGuardado.getNombre())
                .mensaje("Usuario registrado correctamente")
                .cargo(empleadoGuardado.getCargo().name())
                .build();
    }
}