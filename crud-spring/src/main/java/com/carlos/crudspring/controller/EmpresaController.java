package com.carlos.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.crudspring.model.Empresa;
import com.carlos.crudspring.repository.EmpresaRepository;

import lombok.AllArgsConstructor;

@RestController     //Contém um end-point
@RequestMapping("/api/empresas")    //End-point
@AllArgsConstructor //Cria o construtor automaticamente
public class EmpresaController {
    
    private final EmpresaRepository empresaRepository;

    @GetMapping 
    public List<Empresa> list() {
        return empresaRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Long id) {
        return empresaRepository.findById(id)   
        .map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Empresa create(@RequestBody Empresa empresa) {
       return empresaRepository.save(empresa);
    }

    @PutMapping("{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody Empresa empresa) {
        return empresaRepository.findById(id)
        .map(recordFound -> {
            recordFound.setCnpj(empresa.getCnpj());
            recordFound.setNome(empresa.getNome());
            recordFound.setCep(empresa.getCep());
            recordFound.setLogradouro(empresa.getLogradouro());
            recordFound.setNumero(empresa.getNumero());
            recordFound.setComplemento(empresa.getComplemento());
            recordFound.setBairro(empresa.getBairro());
            recordFound.setCidade(empresa.getCidade());
            recordFound.setEstado(empresa.getEstado());
            Empresa updated = empresaRepository.save(recordFound);
            return ResponseEntity.ok().body(updated);
        })
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return empresaRepository.findById(id)
        .map(recordFound -> {
            empresaRepository.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
    }
}