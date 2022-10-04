package com.ecomerce.ecommerce.model.Cart;

import com.ecomerce.ecommerce.model.Costumer.Costumer;
import com.ecomerce.ecommerce.model.Products.Products;

import java.util.List;

public class CartDTO {
    private Integer id;
    private Double amount;
    private List<Products> product;
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
