package com.ecomerce.ecommerce.model.Products;

import com.ecomerce.ecommerce.model.Sellers.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRep extends JpaRepository<Products, Integer> {

}
