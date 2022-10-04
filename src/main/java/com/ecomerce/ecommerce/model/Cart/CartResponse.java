package com.ecomerce.ecommerce.model.Cart;

import com.ecomerce.ecommerce.model.Costumer.Costumer;
import com.ecomerce.ecommerce.model.Products.Products;
import com.ecomerce.ecommerce.model.Products.Reponses.ProductResponseWithoutId;
import com.ecomerce.ecommerce.model.Products.Reponses.ProductsResponse;

import java.util.List;

public class CartResponse {

    private Integer id;
    private Double amount;
    private List<ProductResponseWithoutId> product;
    private Costumer costumer;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ProductResponseWithoutId> getProduct() {
        return product;
    }

    public void setProduct(List<ProductResponseWithoutId> product) {
        this.product = product;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }
}
