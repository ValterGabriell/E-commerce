package com.ecomerce.ecommerce.model.Products;

import com.ecomerce.ecommerce.model.Sellers.Seller;

public class ProductsResponse {

    private Integer id;
    private String name;
    private Double price;
    private Seller seller;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
