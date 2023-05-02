package com.desafioweb.desafio.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String cnpj; 
	
	private String nome; 
	private String cep;
	private String logradouro; 
	private Integer numero; 
	private String complemento; 
	private String cidade;
	private String bairro;
	private String estado;
	
	@ManyToMany
	@JoinTable(name = "empr_forn", joinColumns = @JoinColumn(name = "empr_id"), inverseJoinColumns = @JoinColumn(name = "forn_id"))
	private Set<Fornecedor> fornecedores = new HashSet<Fornecedor>();
	
	public Empresa() {
	}

	public Empresa(String cnpj, String nome, String cep, String logradouro, Integer numero, String complemento,
			String cidade, String bairro, String estado) {
		super();
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

	public Set<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
}
