package com.ecomerce.ecommerce.model.Products;

import com.ecomerce.ecommerce.model.Sellers.Seller;

public class ProductsRequest {
    private String name;
    private Double price;
    private Seller seller_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Seller getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Seller seller_id) {
        this.seller_id = seller_id;
    }
}
