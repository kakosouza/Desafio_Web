package com.desafio.desafio.entities.enums;

public enum FornStatus {
    AGUARDANDO_LIBERAR(1),
    OK(2),
    CANCELADO(3);

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
        throw new IllegalArgumentException("Status do Fornecedor Inválido");
    }
}
