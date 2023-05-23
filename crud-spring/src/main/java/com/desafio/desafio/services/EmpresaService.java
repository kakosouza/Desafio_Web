package com.desafio.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.desafio.entities.Empresa;
import com.desafio.desafio.repositories.EmpresaRepository;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository repository;

    public List<Empresa> findAll() {
        return repository.findAll();
    }

    public Empresa findById(String cnpj) {
        Optional<Empresa> obj = repository.findById(cnpj);
        return obj.get();
    }

    public Empresa insert(Empresa obj) {
        return repository.save(obj);
    }
}
