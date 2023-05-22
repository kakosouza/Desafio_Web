package com.desafio.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.desafio.entities.Fornecedor;
import com.desafio.desafio.repositories.FornecedorRepository;

@Service
public class FornecedorService {
    
    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    public Fornecedor findById(String cnpj) {
        Optional<Fornecedor> obj = repository.findById(cnpj);
        return obj.get();
    }


}
