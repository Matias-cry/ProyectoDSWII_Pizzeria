package com.pizzeria.api_pizzeria.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoResponseDTO {
    private Long id;
    private String clienteNombre;
    private LocalDateTime fechaPedido;
    private String estado;
    private BigDecimal total;
    private List<DetallePedidoResponseDTO> detalles;
}
