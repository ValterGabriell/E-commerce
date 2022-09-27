package com.ecomerce.ecommerce.model.Admin;

public class AdminResponse {
    public String username;
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

}
