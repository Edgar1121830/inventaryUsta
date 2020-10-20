package com.stock.inventario.enums;

public enum EEstados {

    A(1,true),
    I(2,false),
    S(3,false),
    C(4,false);

    private int idEstado;
    private boolean desEstado;

    EEstados(int idEstado, boolean desEstado) {
        this.idEstado = idEstado;
        this.desEstado = desEstado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public boolean getDesEstado() {
        return desEstado;
    }
}
