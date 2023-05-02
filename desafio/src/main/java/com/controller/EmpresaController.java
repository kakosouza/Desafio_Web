package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Empresa;
import com.repositories.EmpresaRepository;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
    
    private final EmpresaRepository empresaRepository;

    public EmpresaController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @GetMapping
    public List<Empresa> list() {
        return empresaRepository.findAll();
    }
}
