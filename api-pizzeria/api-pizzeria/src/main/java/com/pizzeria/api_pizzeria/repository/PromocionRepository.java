package com.pizzeria.api_pizzeria.repository;

import com.pizzeria.api_pizzeria.model.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocionRepository extends JpaRepository<Promocion, Long> {
}
