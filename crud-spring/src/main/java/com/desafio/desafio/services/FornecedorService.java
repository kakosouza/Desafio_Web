package com.desafio.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.desafio.desafio.entities.Fornecedor;
import com.desafio.desafio.repositories.FornecedorRepository;
import com.desafio.desafio.services.exceptions.DatabaseException;
import com.desafio.desafio.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FornecedorService {
    
    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    public Fornecedor findById(String chave) {
        Optional<Fornecedor> obj = repository.findById(chave);
        return obj.orElseThrow(() -> new ResourceNotFoundException(chave));
    }

    public Fornecedor insert(Fornecedor obj) {
        return repository.save(obj);
    }

    public void delete(String chave) {
        try {
            repository.deleteById(chave);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(chave);        
        }
        catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
    }

    public Fornecedor update(String chave, Fornecedor obj) {
        try {
            Fornecedor entity = repository.getReferenceById(chave);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(chave);
        }
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
