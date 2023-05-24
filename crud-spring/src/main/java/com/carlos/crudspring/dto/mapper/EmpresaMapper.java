package com.carlos.crudspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.carlos.crudspring.dto.EmpresaDTO;
import com.carlos.crudspring.model.Empresa;

@Component
public class EmpresaMapper {
    
    public EmpresaDTO toDTO(Empresa empresa) {
        if (empresa == null) {
            return null;
        }

        return new EmpresaDTO(empresa.getId(), empresa.getCnpj(), empresa.getNome(), empresa.getCep(), 
          empresa.getLogradouro(), empresa.getNumero(), empresa.getComplemento(), empresa.getCidade(),
          empresa.getBairro(), empresa.getEstado());
    }

    public Empresa toEntity(EmpresaDTO empresaDTO) {
        Empresa empresa = new Empresa();

        if (empresaDTO == null) {
            return null;
        }
        
        if (empresaDTO.id() != null) {
            empresa.setId(empresaDTO.id());
        }
        empresa.setCnpj(empresaDTO.cnpj());
        empresa.setNome(empresaDTO.nome());
        empresa.setCep(empresaDTO.cep());
        empresa.setLogradouro(empresaDTO.logradouro());
        empresa.setNumero(empresaDTO.numero());
        empresa.setBairro(empresaDTO.bairro());
        empresa.setCidade(empresaDTO.cidade());
        empresa.setEstado(empresaDTO.estado());
        empresa.setComplemento(empresaDTO.complemento());
        return empresa;
    }
}