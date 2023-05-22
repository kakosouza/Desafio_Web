package com.desafio.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desafio.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {
    
}
