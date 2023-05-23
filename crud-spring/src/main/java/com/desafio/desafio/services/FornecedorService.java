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

    public Fornecedor findById(String chave) {
        Optional<Fornecedor> obj = repository.findById(chave);
        return obj.get();
    }

    public Fornecedor insert(Fornecedor obj) {
        return repository.save(obj);
    }

    public void delete(String chave) {
        repository.deleteById(chave);
    }

    public Fornecedor update(String chave, Fornecedor obj) {
        Fornecedor entity = repository.getReferenceById(chave);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Fornecedor entity, Fornecedor obj) {
        entity.setNome(obj.getNome());
        entity.setCep(obj.getCep());
        entity.setLogradouro(obj.getLogradouro());
        entity.setNumero(obj.getNumero());
        entity.setComplemento(obj.getComplemento());
        entity.setBairro(obj.getBairro());
        entity.setCidade(obj.getCidade());
        entity.setEstado(obj.getEstado());
        entity.setDtnascimento(obj.getDtnascimento());
        entity.setEmail(obj.getEmail());
        entity.setRg(obj.getRg());
        entity.setFstatus(obj.getFstatus());
    }
}
