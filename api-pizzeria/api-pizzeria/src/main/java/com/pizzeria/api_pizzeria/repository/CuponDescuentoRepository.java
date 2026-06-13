package com.pizzeria.api_pizzeria.repository;

import com.pizzeria.api_pizzeria.model.CuponDescuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CuponDescuentoRepository extends JpaRepository<CuponDescuento, Long> {
    // Método vital para buscar el cupón por su código de texto (ej: "PIZZA20")
    Optional<CuponDescuento> findByCodigo(String codigo);
}
