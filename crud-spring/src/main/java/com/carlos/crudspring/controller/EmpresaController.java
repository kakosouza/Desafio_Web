package com.carlos.crudspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
