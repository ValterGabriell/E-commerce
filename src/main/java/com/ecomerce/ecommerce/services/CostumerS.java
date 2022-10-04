package com.ecomerce.ecommerce.services;

import com.ecomerce.ecommerce.model.Costumer.Costumer;
import com.ecomerce.ecommerce.model.Costumer.CostumerDTO;
import com.ecomerce.ecommerce.model.Costumer.CostumerRep;
import com.ecomerce.ecommerce.model.Products.Products;
import com.ecomerce.ecommerce.model.Products.ProductsDTO;
import com.ecomerce.ecommerce.model.Products.ProductsRep;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CostumerS {
    @Autowired
    CostumerRep costumerRep;
    @Autowired
    ProductsRep productsRep;

    public CostumerDTO signUpCostumer(CostumerDTO costumerDTO) {
        costumerDTO.setId(null);
        Costumer costumer = Utils.getModelMapperInstance(costumerDTO, Costumer.class);

        Costumer costumerFounded = costumerRep.findByEmail(costumer.getEmail());
        if (costumerFounded == null) {
            String encodedPassword = Utils.encodePassword(costumer.getPassword());
            costumer.setPassword(encodedPassword);
            costumerRep.save(costumer);
            costumerDTO.setId(costumer.getId());
        }
        return costumerDTO;
    }

}
