package com.carlos.crudspring.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmpresaDTO(
        Long id, 
        @NumberFormat @NotNull @Length(min = 14, max = 14) String cnpj, 
        @NotBlank @NotNull @Length(max = 100) String nome, 
        String cep,
        String logradouro, 
        Integer numero, 
        String complemento,
        String cidade, 
        String bairro, 
        String estado) {
}