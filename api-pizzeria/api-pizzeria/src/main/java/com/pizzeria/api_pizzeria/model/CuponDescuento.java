package com.pizzeria.api_pizzeria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cupones_descuento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuponDescuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String codigo; // Ej: "PIZZALOVER", "PROMO2026"

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal porcentajeDescuento; // Ej: 10.00 (para 10%)

    @Column(nullable = false)
    private LocalDateTime fechaExpiracion;

    @Column(nullable = false)
    private Integer usoMaximo; // Cuántas veces se puede usar en total el cupón

    @Column(nullable = false)
    private Integer usoActual = 0; // Cuántas veces se ha usado ya

    @Column(nullable = false)
    private Boolean activo = true;

    // Método para validar si el cupón aún sirve
    public boolean esValido() {
        return activo && LocalDateTime.now().isBefore(fechaExpiracion) && usoActual < usoMaximo;
    }
}
