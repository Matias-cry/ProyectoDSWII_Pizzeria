package com.pizzeria.api_pizzeria.dto;

import com.pizzeria.api_pizzeria.model.Cargo;
import lombok.Data;

@Data
public class EmpleadoResponseDTO {
    private Long id;
    private String nombre;
    private String dni;
    private String telefono;
    private Cargo cargo;
    private String mensaje;
}
