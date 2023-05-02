package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioweb.desafio.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {

}
