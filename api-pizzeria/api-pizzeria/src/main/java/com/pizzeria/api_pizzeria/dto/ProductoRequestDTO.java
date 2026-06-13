package com.pizzeria.api_pizzeria.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductoRequestDTO {
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
}
