package com.ecomerce.ecommerce.services;

import com.ecomerce.ecommerce.model.Products.Products;
import com.ecomerce.ecommerce.model.Products.ProductsDTO;
import com.ecomerce.ecommerce.model.Products.ProductsRep;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsS {
    @Autowired
    ProductsRep productsRep;

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


}
