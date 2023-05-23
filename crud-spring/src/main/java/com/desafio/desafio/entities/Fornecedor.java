package com.desafio.desafio.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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
    private String logradouro;
    private Number numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String email;
    private Date dtnascimento;
    private Number rg;
    private Number fstatus;

    @ManyToMany
    @JoinTable(name = "fornempr",
    joinColumns = @JoinColumn(name = "fornid"),
    inverseJoinColumns = @JoinColumn(name = "emprid"))
    private Set<Empresa> empresas = new HashSet<>();

    public Fornecedor() {
    }

    public Fornecedor(String chave, String nome, String logradouro, Number numero, String complemento, String bairro,
            String cidade, String estado, String cep, String email, Date dtnascimento, Number rg, Number fstatus) {
        this.chave = chave;
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.email = email;
        this.dtnascimento = dtnascimento;
        this.rg = rg;
        this.fstatus = fstatus;
    }

    
    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Number getNumero() {
        return numero;
    }

    public void setNumero(Number numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(Date dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public Number getRg() {
        return rg;
    }

    public void setRg(Number rg) {
        this.rg = rg;
    }

    public Number getFstatus() {
        return fstatus;
    }

    public void setFstatus(Number fstatus) {
        this.fstatus = fstatus;
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
