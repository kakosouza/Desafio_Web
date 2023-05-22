package com.desafio.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafio.entities.Fornecedor;
import com.desafio.desafio.services.FornecedorService;

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
        Fornecedor obj = service.findById(chave);
        return ResponseEntity.ok().body(obj);
    }

}
