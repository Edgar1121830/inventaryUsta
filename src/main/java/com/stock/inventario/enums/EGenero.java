package com.stock.inventario.enums;

import lombok.Getter;
import lombok.Setter;

public enum EGenero {

    M("M","MASCULINO"),
    F("F","FEMENINO"),
    O("O","OTRO");

    @Setter
    @Getter
    private String idGenero;

    @Setter
    @Getter
    private String desc;

    EGenero(String idGenero, String desc) {
        this.idGenero = idGenero;
        this.desc = desc;
    }


}
