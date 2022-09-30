package com.ecomerce.ecommerce.services;

import com.ecomerce.ecommerce.model.Products.Products;
import com.ecomerce.ecommerce.model.Products.ProductsDTO;
import com.ecomerce.ecommerce.model.Products.ProductsRep;
import com.ecomerce.ecommerce.model.Sellers.Seller;
import com.ecomerce.ecommerce.model.Sellers.SellerRep;
import com.ecomerce.ecommerce.util.Utils;
import com.ecomerce.ecommerce.util.VerifyIfProductIdExistsInSellerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductsS {
    @Autowired
    ProductsRep productsRep;
    @Autowired
    SellerRep sellerRep;

    public ProductsDTO createNewProduct(ProductsDTO productsDTO) {
        productsDTO.setId(null);

        Products products = Utils.getModelMapperInstance(productsDTO, Products.class);

        productsRep.save(products);

        productsDTO.setId(products.getId());
        return productsDTO;
    }

    public List<ProductsDTO> listAllProducts() {
        List<Products> productsList = productsRep.findAll();
        return productsList.stream().map(element -> Utils.getModelMapperInstance(element, ProductsDTO.class)).collect(Collectors.toList());
    }


    public String deleteProductById(Integer seller_id, Integer productId) {
        Optional<Seller> seller = sellerRep.findById(seller_id);
        List<Products> productsList = seller.get().getProductsList();
        return VerifyIfProductIdExistsInSellerObject.Companion.verifyAndDeleteProduct(productsList, productId, productsRep);
    }


}
