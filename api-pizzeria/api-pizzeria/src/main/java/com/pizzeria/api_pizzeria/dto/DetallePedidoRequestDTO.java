package com.pizzeria.api_pizzeria.dto;

import lombok.Data;

@Data
public class DetallePedidoRequestDTO {
    private Long productoId;
    private Integer cantidad;
}
