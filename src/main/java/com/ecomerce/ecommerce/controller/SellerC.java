package com.ecomerce.ecommerce.controller;

import com.ecomerce.ecommerce.model.Sellers.Response.SellerResponseCreated;
import com.ecomerce.ecommerce.model.Sellers.Seller;
import com.ecomerce.ecommerce.model.Sellers.SellerDTO;
import com.ecomerce.ecommerce.model.Sellers.SellerRequest;
import com.ecomerce.ecommerce.model.Sellers.SellerResponse;
import com.ecomerce.ecommerce.services.SellerS;
import com.ecomerce.ecommerce.util.Constantes;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SellerC {
    @Autowired
    SellerS sellerS;

    @PostMapping("/seller/signUp")
    public ResponseEntity<SellerResponseCreated> signUpSeller(@RequestBody SellerRequest sellerRequest) {
        SellerDTO sellerDTO = Utils.getModelMapperInstance(sellerRequest, SellerDTO.class);
        sellerDTO = sellerS.signUpSeller(sellerDTO);
        SellerResponseCreated seller = Utils.getModelMapperInstance(sellerDTO, SellerResponseCreated.class);
        return new ResponseEntity<>(seller, HttpStatus.CREATED);
    }

    @PostMapping("/seller/signIn")
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


    @GetMapping("/seller/{seller_id}")
    public ResponseEntity<SellerResponse> getSellerById(@PathVariable Integer seller_id) {
        SellerDTO sellerDTO = sellerS.getSellerById(seller_id);
        SellerResponse sellerResponse = Utils.getModelMapperInstance(sellerDTO, SellerResponse.class);
        return new ResponseEntity<>(sellerResponse, HttpStatus.OK);
    }

    @DeleteMapping("/seller/{id}")
    public ResponseEntity<String> deleteSellerById(@PathVariable Integer id){
        sellerS.deleteSeller(id);
        return new ResponseEntity<>(Constantes.DELETED_OK, HttpStatus.NO_CONTENT);
    }



}
