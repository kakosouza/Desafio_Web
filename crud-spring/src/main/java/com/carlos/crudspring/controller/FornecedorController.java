package com.carlos.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.crudspring.dto.FornecedorDTO;
import com.carlos.crudspring.service.FornecedorService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController     //Contém um end-point
@RequestMapping("/api/fornecedores")    //End-point
public class FornecedorController {
    
    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping 
    public @ResponseBody List<FornecedorDTO> list() {
        return fornecedorService.list();
    }

    @GetMapping("{id}")
    public FornecedorDTO findById(@PathVariable @NotNull @Positive Long id) {
        return fornecedorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public FornecedorDTO create(@RequestBody @Valid @NotNull FornecedorDTO fornecedor) {
       return fornecedorService.create(fornecedor);
    }

    @PutMapping("{id}")
    public FornecedorDTO update(@PathVariable @NotNull @Positive Long id,
             @RequestBody @Valid @NotNull FornecedorDTO fornecedor) {
        return fornecedorService.update(id, fornecedor);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        fornecedorService.delete(id);
    }
}