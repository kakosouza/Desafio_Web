package com.carlos.crudspring.dto;

import java.sql.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FornecedorDTO(
        Long id, 
        @NumberFormat @NotNull @Length(min = 14, max = 14) String chave, 
        @NotBlank @NotNull @Length(max = 100) String nome, 
        String cep,
        String logradouro, 
        Integer numero, 
        String complemento,
        String bairro, 
        String cidade, 
        String estado,
        Integer rg,
        String email,
        Date dtnascimento,
        Integer fstatus) {
}