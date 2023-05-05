package com.carlos.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Empresa create(@RequestBody Empresa empresa) {
       return empresaRepository.save(empresa);
    }
}
