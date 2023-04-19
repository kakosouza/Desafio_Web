package com.desafioweb.desafio.entities.enums;

public enum FornStatus {
	
	OK(1),
	BLOQUEADO(2),
	AGUARDANDO_LIBERAÇÃO(3),
	CANCELADO(4);
	
	private int code;
	
	private FornStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static FornStatus valueOf(int code) {
		for (FornStatus value : FornStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de Status Inválido");
	}
}
