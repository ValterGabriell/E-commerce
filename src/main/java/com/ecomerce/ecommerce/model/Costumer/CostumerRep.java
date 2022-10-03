package com.ecomerce.ecommerce.model.Costumer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRep extends JpaRepository<Costumer, Integer> {
    Costumer findByEmail(String email);
}
