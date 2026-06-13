package com.pizzeria.api_pizzeria.dto;

import com.pizzeria.api_pizzeria.model.Cargo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpleadoRequestDTO {
    private String nombre;
    private String dni;
    private String password;
    private String telefono;
    private Cargo cargo;
}
