package com.ecomerce.ecommerce.services;

import com.ecomerce.ecommerce.model.Products.Products;
import com.ecomerce.ecommerce.model.Products.ProductsDTO;
import com.ecomerce.ecommerce.model.Products.ProductsRep;
import com.ecomerce.ecommerce.model.Sellers.Seller;
import com.ecomerce.ecommerce.model.Sellers.SellerDTO;
import com.ecomerce.ecommerce.model.Sellers.SellerRep;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerS {
    @Autowired
    SellerRep sellerRep;
    @Autowired
    ProductsRep productsRep;


    public SellerDTO signUpSeller(SellerDTO sellerDTO) {
        sellerDTO.setId(null);
        Seller seller = Utils.getModelMapperInstance(sellerDTO, Seller.class);

        Seller sellerFounded = sellerRep.findByEmail(seller.getEmail());
        if (sellerFounded == null) {
            String encodedPassword = Utils.encodePassword(seller.getPassword());
            seller.setPassword(encodedPassword);
            sellerRep.save(seller);
            sellerDTO.setId(seller.getId());
        }
        return sellerDTO;
    }

    public SellerDTO signInSeller(SellerDTO sellerDTO) {
        String email = sellerDTO.getEmail();
        String password = sellerDTO.getPassword();

        Seller sellerFounded = sellerRep.findByEmail(email);
        if (sellerFounded != null) {
            String encodedPassword = Utils.encodePassword(password);
            if (encodedPassword.equals(sellerFounded.getPassword())) {
                return Utils.getModelMapperInstance(sellerFounded, SellerDTO.class);
            }
        }
        return null;
    }



}
