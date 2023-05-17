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

import com.carlos.crudspring.dto.EmpresaDTO;
import com.carlos.crudspring.model.Empresa;
import com.carlos.crudspring.service.EmpresaService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController     //Contém um end-point
@RequestMapping("/api/empresas")    //End-point
public class EmpresaController {
    
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping 
    public @ResponseBody List<EmpresaDTO> list() {
        return empresaService.list();
    }

    @GetMapping("{id}")
    public EmpresaDTO findById(@PathVariable @NotNull @Positive Long id) {
        return empresaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EmpresaDTO create(@RequestBody Empresa empresa) {
       return empresaService.create(empresa);
    }

    @PutMapping("{id}")
    public EmpresaDTO update(@PathVariable @NotNull @Positive Long id,
             @RequestBody @Valid Empresa empresa) {
        return empresaService.update(id, empresa);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        empresaService.delete(id);
    }
}