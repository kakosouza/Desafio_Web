package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empresa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String cnpj; 
	
	private String nome_fantasia; 
	private String cep;
	private String logradouro; 
	private Integer numero; 
	private String complemento; 
	private String cidade;
	private String bairro;
	private String estado;
	
	public Empresa() {
	}

	public Empresa(String cnpj, String nome_fantasia, String cep, String logradouro, Integer numero, String complemento,
			String cidade, String bairro, String estado) {
		super();
		this.cnpj = cnpj;
		this.nome_fantasia = nome_fantasia;
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

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Empresa [cnpj=" + cnpj + ", nome_fantasia=" + nome_fantasia + ", cep=" + cep + ", logradouro="
				+ logradouro + ", numero=" + numero + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", bairro=" + bairro + ", estado=" + estado + "]";
	}
}
