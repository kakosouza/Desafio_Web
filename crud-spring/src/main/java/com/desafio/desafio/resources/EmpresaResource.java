package com.desafio.desafio.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafio.entities.Empresa;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaResource {
    
    @GetMapping
    public ResponseEntity<Empresa> findAll() {
        Empresa emp = new Empresa("11111111111111", "ACCENTURE", null, null, null, null, null, null, null);
        return ResponseEntity.ok().body(emp);
    }
}
