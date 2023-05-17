package com.carlos.crudspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.carlos.crudspring.dto.EmpresaDTO;
import com.carlos.crudspring.model.Empresa;

@Component
public class EmpresaMapper {
    
    public EmpresaDTO toDTO(Empresa empresa) {
        return new EmpresaDTO(empresa.getId(), empresa.getCnpj(), empresa.getNome(), empresa.getCep(), 
          empresa.getLogradouro(), empresa.getNumero(), empresa.getComplemento(), empresa.getCidade(),
          empresa.getBairro(), empresa.getEstado());
    }
}
