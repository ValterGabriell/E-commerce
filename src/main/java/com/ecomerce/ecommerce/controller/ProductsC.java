package com.ecomerce.ecommerce.controller;

import com.ecomerce.ecommerce.model.Products.Products;
import com.ecomerce.ecommerce.model.Products.ProductsDTO;
import com.ecomerce.ecommerce.model.Products.ProductsRequest;
import com.ecomerce.ecommerce.services.ProductsS;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class ProductsC {
    @Autowired
    ProductsS productsS;


    @PostMapping("/product")
    public ResponseEntity<Products> createNewProduct(@RequestBody ProductsRequest productsRequest) {
        ProductsDTO productsDTO = Utils.getModelMapperInstance(productsRequest, ProductsDTO.class);
        productsDTO = productsS.createNewProduct(productsDTO);

        Products products = Utils.getModelMapperInstance(productsDTO, Products.class);
        return new ResponseEntity<>(products, HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Products>> listAllProducts() {
        List<ProductsDTO> listProductsDTO = productsS.listAllProducts();
        List<Products> productsList = listProductsDTO.stream().map(element -> Utils.getModelMapperInstance(element, Products.class)).collect(Collectors.toList());
        return new ResponseEntity<>(productsList, HttpStatus.OK);
    }
}
