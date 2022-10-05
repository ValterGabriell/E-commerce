package com.ecomerce.ecommerce.model.Cart;

import com.ecomerce.ecommerce.model.Costumer.Costumer;
import com.ecomerce.ecommerce.model.Products.Products;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double amount;

    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "idCart"),
            inverseJoinColumns = @JoinColumn(name = "idProduct")
    )
    @JsonBackReference
    private List<Products> product;

    @OneToOne
    @JoinColumn(name = "id")
    @JsonIgnore
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
