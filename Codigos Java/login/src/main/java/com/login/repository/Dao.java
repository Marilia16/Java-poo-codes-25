package com.login.repository;

import java.util.List;

public interface Dao<T> {
    T get(Long cpf);
    List<T> getAll();
    void save(T entity);
    void update(T entity, String[] params);
    void delete(Long cpf);
    boolean ifsenhaisvalid(Long cpf, String senha); 
    void updateSenha(Long cpf, String senha);
    void updateName(Long cpf, String name);
    void updateCpf(Long cpf, Long newCpf);
    boolean ifcpfexists(Long cpf);
    boolean isvalidname(String name);
}
