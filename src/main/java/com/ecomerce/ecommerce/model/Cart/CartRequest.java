package com.ecomerce.ecommerce.model.Cart;

import com.ecomerce.ecommerce.model.Costumer.Costumer;
import com.ecomerce.ecommerce.model.Products.Products;

import java.util.List;

public class CartRequest {
    private List<Products> product;
    private Costumer costumer;

    public List<Products> getProduct() {
        return product;
    }

    public void setProduct(List<Products> product) {
        this.product = product;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }
}
