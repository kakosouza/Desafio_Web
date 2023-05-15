package com.carlos.crudspring.repository;

import com.carlos.crudspring.model.Fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    
}
