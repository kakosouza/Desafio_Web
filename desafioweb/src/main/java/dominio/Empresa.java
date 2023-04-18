package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empresa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String cnpj; 
	
	private String fantasia; 
	private String cep;
	private String lograd; 
	private Integer num; 
	private String compl; 
	private String cidade;
	private String bairro;
	private String estado;
	
	public Empresa() {
	}

	public Empresa(String cnpj, String fantasia, String cep, String lograd, Integer num, String compl, String cidade,
			String bairro, String estado) {
		super();
		this.cnpj = cnpj;
		this.fantasia = fantasia;
		this.cep = cep;
		this.lograd = lograd;
		this.num = num;
		this.compl = compl;
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

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLograd() {
		return lograd;
	}

	public void setLograd(String lograd) {
		this.lograd = lograd;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getCompl() {
		return compl;
	}

	public void setCompl(String compl) {
		this.compl = compl;
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

	@Override
	public String toString() {
		return "Empresa [cnpj=" + cnpj + ", fantasia=" + fantasia + ", cep=" + cep + ", lograd=" + lograd + ", num="
				+ num + ", compl=" + compl + ", cidade=" + cidade + ", bairro=" + bairro + ", estado=" + estado + "]";
	}
}
