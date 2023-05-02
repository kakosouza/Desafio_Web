package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 14, nullable = false)
    private String cnpj; 

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

    public Empresa() {
	}

	public Empresa(Long id, String cnpj, String nome, String cep, String logradouro, Integer numero, String complemento,
            String cidade, String bairro, String estado) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
