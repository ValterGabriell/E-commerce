package com.ecomerce.ecommerce.model.Admin;

import javax.persistence.Column;

public class AdminRequest {
    public String username;
    public String password;
    public Integer cpf;
    public Integer cellphone;
    public String email;


    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getCellphone() {
        return cellphone;
    }

    public void setCellphone(Integer cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
