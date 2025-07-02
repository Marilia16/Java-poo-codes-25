package com.login.model;
public class Logins {
    String name;
    String senha;
    Long cpf;

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getCpf() {
        return cpf;
    }
    public String getName() {
        return name;
    }
    public String getSenha() {
        return senha;
    }
}
