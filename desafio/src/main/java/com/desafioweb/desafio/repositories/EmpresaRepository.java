package com.desafioweb.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioweb.desafio.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {

}
