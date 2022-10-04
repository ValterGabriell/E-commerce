package com.ecomerce.ecommerce.model.Products;

import com.ecomerce.ecommerce.model.Cart.Cart;
import com.ecomerce.ecommerce.model.Costumer.Costumer;
import com.ecomerce.ecommerce.model.Sellers.Seller;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    //dentro da coluna vai ter uma tabela seller_id
    @JoinColumn(name = "seller_id")

    private Seller seller_id;

    @ManyToMany(mappedBy = "product")
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
