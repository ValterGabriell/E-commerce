package com.ecomerce.ecommerce.model.Costumer;

import com.ecomerce.ecommerce.model.Products.Reponses.ProductResponseWithoutId;

import java.util.List;

public class CostumerResponse {
    private Integer id;
    private String email;
    private String cpf_cnpj;
    private String username;
    private Boolean costumer;

    public Boolean getCostumer() {
        return costumer;
    }

    public void setCostumer(Boolean costumer) {
        this.costumer = costumer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
