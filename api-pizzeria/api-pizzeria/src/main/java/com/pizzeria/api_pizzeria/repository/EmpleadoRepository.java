package com.pizzeria.api_pizzeria.repository;

import com.pizzeria.api_pizzeria.model.Cliente;
import com.pizzeria.api_pizzeria.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByNombre(String nombre);
    Optional<Empleado> findByDni(String dni);
    boolean existsByDni(String dni);
}
