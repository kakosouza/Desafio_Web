package com.desafio.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.desafio.desafio.entities.Empresa;
import com.desafio.desafio.repositories.EmpresaRepository;
import com.desafio.desafio.services.exceptions.DatabaseException;
import com.desafio.desafio.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository repository;

    public List<Empresa> findAll() {
        return repository.findAll();
    }

    public Empresa findById(String cnpj) {
        Optional<Empresa> obj = repository.findById(cnpj);
        return obj.orElseThrow(() -> new ResourceNotFoundException(cnpj));
    }

    public Empresa insert(Empresa obj) {
        return repository.save(obj);
    }

    public void delete(String cnpj) {
        try {
            repository.deleteById(cnpj);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(cnpj);
        }
        catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
    }

    public Empresa update(String cnpj, Empresa obj) {
        try {
            Empresa entity = repository.getReferenceById(cnpj);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(cnpj);
        }
    }

    private void updateData(Empresa entity, Empresa obj) {
        entity.setNome(obj.getNome());
        entity.setCep(obj.getCep());
        entity.setLogradouro(obj.getLogradouro());
        entity.setNumero(obj.getNumero());
        entity.setComplemento(obj.getComplemento());
        entity.setBairro(obj.getBairro());
        entity.setCidade(obj.getCidade());
        entity.setEstado(obj.getEstado());
    }
}
