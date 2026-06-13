package com.pizzeria.api_pizzeria.dto;

import lombok.Data;

@Data
public class ClienteRequestDTO {
    private String nombre;
    private String dni;
    private String telefono;
    private String direccion;
}
