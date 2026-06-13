package com.pizzeria.api_pizzeria.repository;

import com.pizzeria.api_pizzeria.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
