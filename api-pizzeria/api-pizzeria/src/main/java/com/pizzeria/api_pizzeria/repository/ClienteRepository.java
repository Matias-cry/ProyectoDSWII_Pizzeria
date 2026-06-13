package com.pizzeria.api_pizzeria.repository;

import com.pizzeria.api_pizzeria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByClienteNombre(String clienteNombre);
    Optional<Cliente> findByDni(String dni);
    boolean existsByDni(String dni);
}