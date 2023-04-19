package com.desafioweb.desafio.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.desafioweb.desafio.entities.enums.FornStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String chave;

	private String nome;
	private Integer rg;
	private Date dtNascimento;
	private String email;
	private String cep;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String cidade;
	private String bairro;
	private Integer fstatus;
	private String estado;

	@ManyToMany
	@JoinTable(name = "forn_Empr", joinColumns = @JoinColumn(name = "chave"), inverseJoinColumns = @JoinColumn(name = "cnpj"))
	private Set<Empresa> empresas = new HashSet<Empresa>();

	public Fornecedor() {
	}

	public Fornecedor(String chave, String nome, Integer rg, Date dtNascimento, String email, String cep,
			String logradouro, Integer numero, String complemento, String cidade, String bairro, FornStatus fstatus,
			String estado) {
		super();
		this.chave = chave;
		this.nome = nome;
		this.rg = rg;
		this.dtNascimento = dtNascimento;
		this.email = email;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.bairro = bairro;
		setFstatus(fstatus);
		this.estado = estado;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public FornStatus getFstatus() {
		return FornStatus.valueOf(fstatus);
	}

	public void setFstatus(FornStatus fstatus) {
		if (fstatus != null) {
			this.fstatus = fstatus.getCode();
		}
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set<Empresa> getEmpresas() {
		return empresas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chave == null) ? 0 : chave.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (chave == null) {
			if (other.chave != null)
				return false;
		} else if (!chave.equals(other.chave))
			return false;
		return true;
	}

}
