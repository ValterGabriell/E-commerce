package com.ecomerce.ecommerce.services;

import com.ecomerce.ecommerce.model.Sellers.Seller;
import com.ecomerce.ecommerce.model.Sellers.SellerDTO;
import com.ecomerce.ecommerce.model.Sellers.SellerRep;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerS {
    @Autowired
    SellerRep sellerRep;


    public SellerDTO createNewSeller(SellerDTO sellerDTO) {
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


}
