package com.desafioweb.desafio.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafioweb.desafio.entities.Fornecedor;
import com.services.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResource {
	
	@Autowired
	private FornecedorService service;

	@GetMapping
	public ResponseEntity<List<Fornecedor>> findAll() {
		List<Fornecedor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{chave}")
	public ResponseEntity<Fornecedor> findById(@PathVariable String chave) {
		Fornecedor forn = service.FindById(chave);
		return ResponseEntity.ok().body(forn);
	}
	
	//INSERT
	@PostMapping
	public ResponseEntity<Fornecedor> insert(@RequestBody Fornecedor obj) {
		obj = service.insert(obj);
		// Pega o status de retorno do Insert
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{chave}").buildAndExpand(obj.getChave()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	//DELETE
	@DeleteMapping(value = "/{chave}")
	public ResponseEntity<Void> delete(@PathVariable String chave) {
		service.delete(chave);
		return ResponseEntity.noContent().build();
	}
	
	//UPDATE
	@PutMapping(value = "/{chave}")
	public ResponseEntity<Fornecedor> update(@PathVariable String chave, @RequestBody Fornecedor obj) {
		obj = service.update(chave, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
