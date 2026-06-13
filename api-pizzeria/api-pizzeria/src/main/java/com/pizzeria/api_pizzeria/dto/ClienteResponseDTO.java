package com.pizzeria.api_pizzeria.dto;

import lombok.Data;

@Data
public class ClienteResponseDTO {
    private Long id;
    private String nombre;
    private String dni;
    private String telefono;
    private String direccion;
}
