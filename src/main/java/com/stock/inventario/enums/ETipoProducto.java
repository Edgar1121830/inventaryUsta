package com.stock.inventario.enums;

import lombok.Getter;

public enum ETipoProducto {

    LACTEOS(1,"LACTEOS"),
    VEGETALES(2,"VEGETALES"),
    ROPA(3,"ROPA"),
    ELECTRODOMESTICOS(4,"ELECTRODOMESTICOS"),
    PANADERIA(5,"PANADERIA"),
    TECNOLOGIA(6, "TECNOLOGIA"),
    MEDICOS(7,"MEDICOS");


    @Getter
    private int id;
    @Getter
    private String descripcion;

    ETipoProducto(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return "ETipoProducto{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
