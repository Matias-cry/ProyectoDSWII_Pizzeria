package com.pizzeria.api_pizzeria.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class DetallePedidoResponseDTO {
    private Long id;
    private Long productoId;
    private String productoNombre;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
}
