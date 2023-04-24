package com.desafioweb.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.desafioweb.desafio.entities.Fornecedor;
import com.desafioweb.desafio.repositories.FornecedorRepository;
import com.desafioweb.desafio.services.exceptions.DatabaseException;
import com.desafioweb.desafio.services.exceptions.ResourceNotFoundException;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;
	
	public List<Fornecedor> findAll() {
		return repository.findAll();
	}
	
	public Fornecedor FindById(String chave) {
		Optional<Fornecedor> obj = repository.findById(chave);
		return obj.orElseThrow(() -> new ResourceNotFoundException(chave));
	}
	
	//INSERT
	public Fornecedor insert(Fornecedor obj) {
		return repository.save(obj);
	}
	
	//DELETE
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
	
	//UPDATE
	public Fornecedor update(String chave, Fornecedor obj) {
		Fornecedor entidade = repository.getReferenceById(chave);
		updateData(entidade, obj);
		return repository.save(entidade);
	}

	//Método que move os campos
	private void updateData(Fornecedor entidade, Fornecedor obj) {
		entidade.setBairro(obj.getBairro());
		entidade.setCep(obj.getCep());
		entidade.setCidade(obj.getCidade());
		entidade.setComplemento(obj.getComplemento());
		entidade.setDtNascimento(obj.getDtNascimento());
		entidade.setEmail(obj.getEmail());
		entidade.setEstado(obj.getEstado());
//		entidade.setFstatus(obj.getFstatus());
		entidade.setLogradouro(obj.getLogradouro());
		entidade.setNome(obj.getNome());
		entidade.setNumero(obj.getNumero());
		entidade.setRg(obj.getRg());
	}
}
