package com.pizzeria.api_pizzeria.controller;

import com.pizzeria.api_pizzeria.dto.EmpleadoResponseDTO;
import com.pizzeria.api_pizzeria.dto.EmpleadoRequestDTO;
import com.pizzeria.api_pizzeria.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @GetMapping
    public List<EmpleadoResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    /*@PostMapping
    public EmpleadoResponseDTO guardar(@RequestBody EmpleadoRequestDTO dto) {
        return service.guardar(dto);
    }*/
}
