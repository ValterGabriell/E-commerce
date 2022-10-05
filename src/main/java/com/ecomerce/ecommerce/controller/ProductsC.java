package com.ecomerce.ecommerce.controller;

import com.ecomerce.ecommerce.model.Products.ProductsDTO;
import com.ecomerce.ecommerce.model.Products.ProductsRequest;
import com.ecomerce.ecommerce.model.Products.Reponses.ProductResponseWithId;
import com.ecomerce.ecommerce.model.Products.Reponses.ProductsResponse;
import com.ecomerce.ecommerce.services.ProductsS;
import com.ecomerce.ecommerce.util.Constantes;
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
    public ResponseEntity<ProductResponseWithId> createNewProduct(@RequestBody ProductsRequest productsRequest) {
        ProductsDTO productsDTO = Utils.getModelMapperInstance(productsRequest, ProductsDTO.class);
        productsDTO = productsS.createNewProduct(productsDTO);

        ProductResponseWithId products = Utils.getModelMapperInstance(productsDTO, ProductResponseWithId.class);
        return new ResponseEntity<>(products, HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductsResponse>> listAllProducts() {
        List<ProductsDTO> listProductsDTO = productsS.listAllProducts();
        List<ProductsResponse> productsList = listProductsDTO.stream().map(element -> Utils.getModelMapperInstance(element, ProductsResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(productsList, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductsResponse> getProductById(@PathVariable Integer id) {
        ProductsResponse productsResponse = Utils.getModelMapperInstance(productsS.getProductById(id), ProductsResponse.class);
        return new ResponseEntity<>(productsResponse, HttpStatus.OK);
    }

    @DeleteMapping("/product/{seller_id}/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer seller_id, @PathVariable Integer productId) {
        String response = productsS.deleteProductById(seller_id, productId);
        if (response.equals(Constantes.DELETED_FAIL)){
            return new ResponseEntity<>(Constantes.NOT_FOUND, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
    }


}
