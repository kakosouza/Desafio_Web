package com.carlos.crudspring.repository;

import com.carlos.crudspring.model.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository  extends JpaRepository<Empresa, Long> {
    
}
