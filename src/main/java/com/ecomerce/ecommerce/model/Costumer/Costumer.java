package com.ecomerce.ecommerce.model.Costumer;

import javax.persistence.*;

@Entity
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf_cnpj")
    private String cpf_cnpj;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "costumer")
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
