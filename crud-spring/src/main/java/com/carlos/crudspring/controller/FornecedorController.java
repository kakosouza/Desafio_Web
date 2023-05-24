package com.carlos.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.crudspring.model.Fornecedor;
import com.carlos.crudspring.repository.FornecedorRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
@RestController     //Contém um end-point
@RequestMapping("/api/fornecedores")    //End-point
@AllArgsConstructor //Cria o construtor automaticamente
public class FornecedorController {
    
    private final FornecedorRepository fornecedorRepository;

    @GetMapping 
    public List<Fornecedor> list() {
        return fornecedorRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable @NotNull @Positive Long id) {
        return fornecedorRepository.findById(id)   
        .map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Fornecedor create(@RequestBody @Valid Fornecedor fornecedor) {
       return fornecedorRepository.save(fornecedor);
    }

    @PutMapping("{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable @NotNull @Positive Long id, 
            @RequestBody @Valid Fornecedor fornecedor) {
        return fornecedorRepository.findById(id)
        .map(recordFound -> {
            recordFound.setChave(fornecedor.getChave());
            recordFound.setNome(fornecedor.getNome());
            recordFound.setCep(fornecedor.getCep());
            recordFound.setLogradouro(fornecedor.getLogradouro());
            recordFound.setNumero(fornecedor.getNumero());
            recordFound.setComplemento(fornecedor.getComplemento());
            recordFound.setBairro(fornecedor.getBairro());
            recordFound.setCidade(fornecedor.getCidade());
            recordFound.setEstado(fornecedor.getEstado());
            recordFound.setDtnascimento(fornecedor.getDtnascimento());
            recordFound.setEmail(fornecedor.getEmail());
            recordFound.setRg(fornecedor.getRg());
            recordFound.setFstatus(fornecedor.getFstatus());
            Fornecedor updated = fornecedorRepository.save(recordFound);
            return ResponseEntity.ok().body(updated);
        })
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id) {
        return fornecedorRepository.findById(id)
        .map(recordFound -> {
            fornecedorRepository.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
    }
}