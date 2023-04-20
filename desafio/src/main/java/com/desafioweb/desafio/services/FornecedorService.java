package com.desafioweb.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioweb.desafio.entities.Fornecedor;
import com.desafioweb.desafio.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;
	
	public List<Fornecedor> findAll() {
		return repository.findAll();
	}
	
	public Fornecedor FindById(String chave) {
		Optional<Fornecedor> obj = repository.findById(chave);
		return obj.get();
	}
	
	public Fornecedor insert(Fornecedor obj) {
		return repository.save(obj);
	}
}
