package com.ecomerce.ecommerce.model.Costumer;

public class CostumerRequest {

    private String email;
    private String cpf_cnpj;
    private String username;
    private String password;
    private Boolean costumer;

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

    public Boolean getCostumer() {
        return costumer;
    }

    public void setCostumer(Boolean costumer) {
        this.costumer = costumer;
    }
}
