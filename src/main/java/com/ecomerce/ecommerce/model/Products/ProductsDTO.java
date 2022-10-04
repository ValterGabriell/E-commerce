package com.ecomerce.ecommerce.model.Products;

import com.ecomerce.ecommerce.model.Cart.Cart;
import com.ecomerce.ecommerce.model.Costumer.Costumer;
import com.ecomerce.ecommerce.model.Sellers.Seller;

import javax.persistence.*;
import java.util.List;

public class ProductsDTO {

    private Integer id;
    private String name;
    private Double price;
    private Seller seller_id;
    private List<Cart> cartList;

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

    public Seller getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Seller seller_id) {
        this.seller_id = seller_id;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
