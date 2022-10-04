package com.ecomerce.ecommerce.controller;

import com.ecomerce.ecommerce.model.Cart.CartDTO;
import com.ecomerce.ecommerce.model.Cart.CartRequest;
import com.ecomerce.ecommerce.model.Cart.CartResponse;
import com.ecomerce.ecommerce.services.CartS;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartC {
    @Autowired
    CartS cartS;

    @GetMapping("/get/{costumer_id}")
    public ResponseEntity<CartResponse> getCartById(@PathVariable Integer costumer_id){
        CartDTO cartDTO = cartS.getCartById(costumer_id);
        CartResponse cartResponse = Utils.getModelMapperInstance(cartDTO, CartResponse.class);
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }

    @PostMapping("/product/add")
    public ResponseEntity<CartResponse> addCar(@RequestBody CartRequest cartRequest) {
        CartDTO cartDTO = Utils.getModelMapperInstance(cartRequest, CartDTO.class);
        cartDTO = cartS.addCar(cartDTO);
        CartResponse cart = Utils.getModelMapperInstance(cartDTO, CartResponse.class);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }



}
