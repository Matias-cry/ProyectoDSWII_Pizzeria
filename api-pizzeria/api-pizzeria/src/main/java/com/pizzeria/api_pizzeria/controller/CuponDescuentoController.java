package com.pizzeria.api_pizzeria.controller;

import com.pizzeria.api_pizzeria.dto.CuponRequestDTO;
import com.pizzeria.api_pizzeria.dto.CuponResponseDTO;
import com.pizzeria.api_pizzeria.service.CuponDescuentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cupones")
@RequiredArgsConstructor
public class CuponDescuentoController {

    private final CuponDescuentoService cuponService;

    @PostMapping
    public ResponseEntity<CuponResponseDTO> crear(@RequestBody CuponRequestDTO dto) {
        return new ResponseEntity<>(cuponService.guardar(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CuponResponseDTO>> listar() {
        return ResponseEntity.ok(cuponService.listarTodos());
    }
}
