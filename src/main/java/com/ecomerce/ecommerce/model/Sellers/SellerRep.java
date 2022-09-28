package com.ecomerce.ecommerce.model.Sellers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRep extends JpaRepository<Seller, Integer> {
    Seller findByEmail(String email);
}
