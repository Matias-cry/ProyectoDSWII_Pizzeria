package com.pizzeria.api_pizzeria.dto;

import lombok.Data;
import java.util.List;

@Data
public class PedidoRequestDTO {
    private String clienteNombre;
    private String codigoCupon;
    private List<DetallePedidoRequestDTO> detalles;
}
