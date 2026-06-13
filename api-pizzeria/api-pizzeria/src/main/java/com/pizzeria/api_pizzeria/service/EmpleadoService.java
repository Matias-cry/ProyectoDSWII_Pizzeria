package com.pizzeria.api_pizzeria.service;

import com.pizzeria.api_pizzeria.dto.EmpleadoRequestDTO;
import com.pizzeria.api_pizzeria.dto.EmpleadoResponseDTO;
import com.pizzeria.api_pizzeria.model.Empleado;
import com.pizzeria.api_pizzeria.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;
    private PasswordEncoder passwordEncoder;

    /* public EmpleadoResponseDTO guardar(EmpleadoRequestDTO dto) {
        if (repository.existsByDni(dto.getDni())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El número de DNI ya está registrado");
        }

        Empleado empleado = new Empleado();

        empleado.setNombre(dto.getNombre());
        empleado.setDni(dto.getDni());
        empleado.setPassword(passwordEncoder.encode(dto.getPassword()));
        empleado.setTelefono(dto.getTelefono());
        empleado.setCargo(dto.getCargo());

        empleado = repository.save(empleado);

        EmpleadoResponseDTO response = new EmpleadoResponseDTO();

        response.setId(empleado.getId());
        response.setNombre(empleado.getNombre());
        response.setDni(empleado.getDni());
        response.setTelefono(empleado.getTelefono());
        response.setCargo(empleado.getCargo());

        return response;
    } */

    public List<EmpleadoResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(empleado -> {
                    EmpleadoResponseDTO dto = new EmpleadoResponseDTO();

                    dto.setId(empleado.getId());
                    dto.setNombre(empleado.getNombre());
                    dto.setDni(empleado.getDni());
                    dto.setTelefono(empleado.getTelefono());
                    dto.setCargo(empleado.getCargo());

                    return dto;
                })
                .collect(Collectors.toList());
    }
}
