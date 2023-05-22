package com.desafio.desafio.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafio.entities.Fornecedor;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResource {
    
    @GetMapping
    public ResponseEntity<Fornecedor> findAll() {
        Fornecedor emp = new Fornecedor("00022222222222", "PEDRO", null, null, null, null, null, null, null, null, null, null, null);
        return ResponseEntity.ok().body(emp);
    }

}
