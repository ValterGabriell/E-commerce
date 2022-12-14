package com.ecomerce.ecommerce.model.Products.Reponses;

import com.ecomerce.ecommerce.model.Sellers.Seller;

public class ProductResponseWithId {
    private Integer id;
    private String name;
    private Double price;
    private Seller seller_id;

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

    public Integer getSeller_id() {
        return seller_id.getId();
    }

    public void setSeller_id(Seller seller_id) {
        this.seller_id = seller_id;
    }
}
