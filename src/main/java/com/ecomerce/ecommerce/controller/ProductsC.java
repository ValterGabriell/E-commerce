package com.ecomerce.ecommerce.controller;

import com.ecomerce.ecommerce.model.Products.ProductsDTO;
import com.ecomerce.ecommerce.model.Products.ProductsRequest;
import com.ecomerce.ecommerce.model.Products.ProductsResponse;
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
    public ResponseEntity<ProductsResponse> createNewProduct(@RequestBody ProductsRequest productsRequest) {
        ProductsDTO productsDTO = Utils.getModelMapperInstance(productsRequest, ProductsDTO.class);
        productsDTO = productsS.createNewProduct(productsDTO);

        ProductsResponse products = Utils.getModelMapperInstance(productsDTO, ProductsResponse.class);
        return new ResponseEntity<>(products, HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductsResponse>> listAllProducts() {
        List<ProductsDTO> listProductsDTO = productsS.listAllProducts();
        List<ProductsResponse> productsList = listProductsDTO.stream().map(element -> Utils.getModelMapperInstance(element, ProductsResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(productsList, HttpStatus.OK);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer productId) {
        return new ResponseEntity<>(productsS.deleteProductById(productId), HttpStatus.NO_CONTENT);
    }



}
