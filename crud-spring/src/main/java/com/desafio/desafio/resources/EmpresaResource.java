package com.desafio.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafio.entities.Empresa;
import com.desafio.desafio.services.EmpresaService;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaResource {

    @Autowired
    private EmpresaService service;
    
    @GetMapping
    public ResponseEntity<List<Empresa>> findAll() {
        List<Empresa> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{cnpj}")
    public ResponseEntity<Empresa> findById(@PathVariable String cnpj) {
        Empresa obj = service.findById(cnpj);
        return ResponseEntity.ok().body(obj);
    }
}
