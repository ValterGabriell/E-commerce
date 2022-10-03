package com.ecomerce.ecommerce.services;

import com.ecomerce.ecommerce.model.Costumer.Costumer;
import com.ecomerce.ecommerce.model.Costumer.CostumerDTO;
import com.ecomerce.ecommerce.model.Costumer.CostumerRep;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostumerS {
    @Autowired
    CostumerRep costumerRep;


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
