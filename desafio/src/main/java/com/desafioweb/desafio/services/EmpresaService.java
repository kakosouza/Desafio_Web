package com.desafioweb.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.desafioweb.desafio.entities.Empresa;
import com.desafioweb.desafio.repositories.EmpresaRepository;
import com.desafioweb.desafio.services.exceptions.DatabaseException;
import com.desafioweb.desafio.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
	public List<Empresa> findAll() {
		return repository.findAll();
	}
	
	public Empresa FindById(String cnpj) {
		Optional<Empresa> obj = repository.findById(cnpj);
		return obj.orElseThrow(() -> new ResourceNotFoundException(cnpj));
	}
	
	//INSERT
	public Empresa insert(Empresa obj) {
		return repository.save(obj);
	}
	
	//DELETE
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
	
	//UPDATE
	public Empresa update(String cnpj, Empresa obj) {
		try {
		Empresa entidade = repository.getReferenceById(cnpj);
		updateData(entidade, obj);
		return repository.save(entidade);
		}
		catch (EntityNotFoundException e ) {
			throw new ResourceNotFoundException(cnpj);
		}
	}

	//Método que move os campos
	private void updateData(Empresa entidade, Empresa obj) {
		entidade.setBairro(obj.getBairro());
		entidade.setCep(obj.getCep());
		entidade.setCidade(obj.getCidade());
		entidade.setComplemento(obj.getComplemento());
		entidade.setEstado(obj.getEstado());
		entidade.setLogradouro(obj.getLogradouro());
		entidade.setNumero(obj.getNumero());
		entidade.setNome_fantasia(obj.getNome_fantasia());
	}
}
