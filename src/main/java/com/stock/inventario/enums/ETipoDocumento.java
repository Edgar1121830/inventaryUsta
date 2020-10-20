package com.stock.inventario.enums;

import lombok.Getter;

public enum ETipoDocumento {

    CEDULA(1, "CEDULA"),
    TARJETA_IDENTIDAD(2, "TARJETA_IDENTIDAD"),
    TARJETA_EXTRANJERA(3, "TARJETA_EXTRANJERA"),
    PASAPORTE(4,"PASAPORTE"),
    PERMISO_ESPECIAL(5,"PERMISO_ESPECIAL"),
    NIT(6, "NIT");

    @Getter
    private int id;
    @Getter
    private String descripcion;

    ETipoDocumento(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ETipoDocumento{" +
                "id=" + id +
                '}';
    }
}