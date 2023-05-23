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

    @PostMapping
    public ResponseEntity<Fornecedor> insert(@RequestBody Fornecedor obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{chave}").buildAndExpand(obj.getChave()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{chave}")
    public ResponseEntity<Void> delete(@PathVariable String chave) {
        service.delete(chave);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{chave}")
    public ResponseEntity<Fornecedor> update(@PathVariable String chave, @RequestBody Fornecedor obj) {
        obj = service.update(chave, obj);
        return ResponseEntity.ok().body(obj);
    }
}
