package com.carlos.crudspring.model;

import java.sql.Date;

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
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NumberFormat
    @NotNull
    @Column(length = 14, nullable = false)
    private String chave; 

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
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
   
    @Column(length = 8, nullable = true)
	private Date dtnascimento;

    @Column(length = 20, nullable = true)
	private String email;

    @Column(length = 1, nullable = true)
	private Integer fstatus;

    @Column(length = 10, nullable = true)
	private Integer rg;
}
