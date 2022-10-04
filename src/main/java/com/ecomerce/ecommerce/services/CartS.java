package com.ecomerce.ecommerce.services;

import com.ecomerce.ecommerce.model.Cart.Cart;
import com.ecomerce.ecommerce.model.Cart.CartDTO;
import com.ecomerce.ecommerce.model.Cart.CartRep;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartS {
    @Autowired
    CartRep cartRep;


    public CartDTO getCartById(Integer costumer_id){
        Optional<Cart> cart = cartRep.findById(costumer_id);
        if (cart.isPresent()){
            return Utils.getModelMapperInstance(cart.get(), CartDTO.class);
        }
        return new CartDTO();
    }

}
