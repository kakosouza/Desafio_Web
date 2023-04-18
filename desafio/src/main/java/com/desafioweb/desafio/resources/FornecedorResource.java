package com.desafioweb.desafio.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioweb.desafio.entities.Fornecedor;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResource {

	@GetMapping
	public ResponseEntity<Fornecedor> findAll() {
		Fornecedor f = new Fornecedor("00011111111111", null, null, null, null, null, null, null, null, null, null, null);
		return ResponseEntity.ok().body(f);
	}
}
