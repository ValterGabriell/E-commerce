package com.ecomerce.ecommerce.model.Admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdminRep extends CrudRepository<Admin, Integer> {
    Admin findByUsername(String username);


}
