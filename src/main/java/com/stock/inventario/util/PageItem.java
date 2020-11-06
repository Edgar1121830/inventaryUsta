package com.stock.inventario.util;

import lombok.Getter;

/**
 * pagina que se encarga de listar paginador
 */
public class PageItem {

    @Getter
    private int numero;
    @Getter
    private boolean actual;

    public PageItem(int numero, boolean actual) {
        this.numero = numero;
        this.actual = actual;
    }
}
