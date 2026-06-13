package com.pizzeria.api_pizzeria.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CuponRequestDTO {
    private String codigo;
    private BigDecimal porcentajeDescuento;
    private LocalDateTime fechaExpiracion;
    private Integer usoMaximo;
}