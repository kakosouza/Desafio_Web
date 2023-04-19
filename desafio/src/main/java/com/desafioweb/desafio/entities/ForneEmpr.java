package com.desafioweb.desafio.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ForneEmpr implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private String idforn;
	private String idempr;

	public ForneEmpr() {
	}

	public ForneEmpr(Long id, String idforn, String idempr) {
		super();
		this.id = id;
		this.idforn = idforn;
		this.idempr = idempr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdforn() {
		return idforn;
	}

	public void setIdforn(String idforn) {
		this.idforn = idforn;
	}

	public String getIdempr() {
		return idempr;
	}

	public void setIdempr(String idempr) {
		this.idempr = idempr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ForneEmpr other = (ForneEmpr) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
