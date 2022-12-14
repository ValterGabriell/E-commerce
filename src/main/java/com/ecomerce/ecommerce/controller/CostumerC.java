package com.ecomerce.ecommerce.controller;

import com.ecomerce.ecommerce.model.Costumer.CostumerDTO;
import com.ecomerce.ecommerce.model.Costumer.CostumerRequest;
import com.ecomerce.ecommerce.model.Costumer.Response.CostumerResponseWithoutCart;
import com.ecomerce.ecommerce.services.CostumerS;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/costumer")
public class CostumerC {
    @Autowired
    CostumerS costumerS;

    @PostMapping("/signUp")
    public ResponseEntity<CostumerResponseWithoutCart> signUpCostumer(@RequestBody CostumerRequest costumerRequest) {
        CostumerDTO costumerDTO = Utils.getModelMapperInstance(costumerRequest, CostumerDTO.class);
        costumerDTO = costumerS.signUpCostumer(costumerDTO);
        CostumerResponseWithoutCart costumerResponse = Utils.getModelMapperInstance(costumerDTO, CostumerResponseWithoutCart.class);
        return new ResponseEntity<>(costumerResponse, HttpStatus.CREATED);
    }
}
