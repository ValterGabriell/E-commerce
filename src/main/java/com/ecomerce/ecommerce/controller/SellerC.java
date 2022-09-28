package com.ecomerce.ecommerce.controller;

import com.ecomerce.ecommerce.model.Sellers.Seller;
import com.ecomerce.ecommerce.model.Sellers.SellerDTO;
import com.ecomerce.ecommerce.model.Sellers.SellerRequest;
import com.ecomerce.ecommerce.services.SellerS;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SellerC {
    @Autowired
    SellerS sellerS;

    @PostMapping("/seller")
    public ResponseEntity<Seller> createNewSeller(@RequestBody SellerRequest sellerRequest) {
        SellerDTO sellerDTO = Utils.getModelMapperInstance(sellerRequest, SellerDTO.class);
        sellerDTO = sellerS.createNewSeller(sellerDTO);
        Seller seller = Utils.getModelMapperInstance(sellerDTO, Seller.class);
        return new ResponseEntity<>(seller, HttpStatus.CREATED);
    }


}
