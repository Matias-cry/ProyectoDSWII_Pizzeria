package com.pizzeria.api_pizzeria.controller;

import com.pizzeria.api_pizzeria.dto.ClienteRequestDTO;
import com.pizzeria.api_pizzeria.dto.ClienteResponseDTO;
import com.pizzeria.api_pizzeria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public ClienteResponseDTO guardar(@RequestBody ClienteRequestDTO dto) {
        return service.guardar(dto);
    }
}

