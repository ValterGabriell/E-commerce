package com.ecomerce.ecommerce.controller;

import com.ecomerce.ecommerce.model.Sellers.Seller;
import com.ecomerce.ecommerce.model.Sellers.SellerDTO;
import com.ecomerce.ecommerce.model.Sellers.SellerRequest;
import com.ecomerce.ecommerce.model.Sellers.SellerResponse;
import com.ecomerce.ecommerce.services.SellerS;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerC {
    @Autowired
    SellerS sellerS;

    @PostMapping("/signUp")
    public ResponseEntity<SellerResponse> signUpSeller(@RequestBody SellerRequest sellerRequest) {
        SellerDTO sellerDTO = Utils.getModelMapperInstance(sellerRequest, SellerDTO.class);
        sellerDTO = sellerS.signUpSeller(sellerDTO);
        SellerResponse seller = Utils.getModelMapperInstance(sellerDTO, SellerResponse.class);
        return new ResponseEntity<>(seller, HttpStatus.CREATED);
    }

    @PostMapping("/signIn")
    public ResponseEntity<SellerResponse> singInSeller(@RequestBody SellerRequest sellerRequest) {
        SellerDTO sellerDTO = Utils.getModelMapperInstance(sellerRequest, SellerDTO.class);
        sellerDTO = sellerS.signInSeller(sellerDTO);
        if (sellerDTO != null) {
            SellerResponse seller = Utils.getModelMapperInstance(sellerDTO, SellerResponse.class);
            return new ResponseEntity<>(seller, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new SellerResponse(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/sellers/{seller_id}")
    public ResponseEntity<SellerResponse> getSellerById(@PathVariable Integer seller_id) {
        SellerDTO sellerDTO = sellerS.getSellerById(seller_id);
        SellerResponse sellerResponse = Utils.getModelMapperInstance(sellerDTO, SellerResponse.class);
        return new ResponseEntity<>(sellerResponse, HttpStatus.OK);
    }

}
