package com.pizzeria.api_pizzeria.repository;


import com.pizzeria.api_pizzeria.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByActivoTrue();
}
