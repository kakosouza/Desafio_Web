package com.carlos.crudspring.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data       //Gera os Get's e Set's automaticamente
@Entity     //Anotação de Entidade que faz o mapeamente com o Banco de Dados
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NumberFormat
    @NotNull
    @Column(length = 14, nullable = false)
    @Length(min = 14, max = 14)
    private String cnpj; 

    @NotBlank
    @NotNull
    @Column(length = 100, nullable = false)
    @Length(max = 100)
    private String nome; 

    @Column(length = 8, nullable = true)
    private String cep;

    @Column(length = 100, nullable = true)
    private String logradouro; 

    @Column(length = 5, nullable = true)
    private Integer numero; 

    @Column(length = 50, nullable = true)
    private String complemento; 

    @Column(length = 100, nullable = true)
    private String cidade;

    @Column(length = 50, nullable = true)
    private String bairro;

    @Column(length = 2, nullable = true)
	private String estado;
   
}
