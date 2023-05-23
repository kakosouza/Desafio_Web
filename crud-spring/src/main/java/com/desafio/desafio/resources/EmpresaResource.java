package com.desafio.desafio.resources;

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

    @PostMapping
    public ResponseEntity<Empresa> insert(@RequestBody Empresa obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{cnpj}").buildAndExpand(obj.getCnpj()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{cnpj}")
    public ResponseEntity<Void> delete(@PathVariable String cnpj) {
        service.delete(cnpj);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{cnpj}")
    public ResponseEntity<Empresa> update(@PathVariable String cnpj, @RequestBody Empresa obj) {
        obj = service.update(cnpj, obj);
        return ResponseEntity.ok().body(obj);
    }   
}
