package com.desafio.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desafio.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {
    
}
