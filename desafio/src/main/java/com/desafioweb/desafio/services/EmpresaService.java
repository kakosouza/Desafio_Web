package com.desafioweb.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioweb.desafio.entities.Empresa;
import com.desafioweb.desafio.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
	public List<Empresa> findAll() {
		return repository.findAll();
	}
	
	public Empresa FindById(String cnpj) {
		Optional<Empresa> obj = repository.findById(cnpj);
		return obj.get();
	}
}
