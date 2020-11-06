package com.stock.inventario.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * se encarga de mostrar el objeto que esta en la
 * pagina actual
 * @param <T>
 */
public class PageRender<T>{

    @Setter
    @Getter
    private String url;
    private Page<T> page;

    @Getter
    private int totalPaginas;
    @Getter
    private int numElementoPorPagina;
    @Getter
    private int paginaActual;
    @Getter
    private List<PageItem> paginas;

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;

        this.paginas = new ArrayList<PageItem>();

        numElementoPorPagina = page.getSize();

        totalPaginas = page.getTotalPages();

        paginaActual = page.getNumber() + 1;

        int desde, hasta;

        if (totalPaginas <= numElementoPorPagina) {
            desde = 1;
            hasta = totalPaginas;
        } else {
            if (paginaActual <= numElementoPorPagina / 2) {
                desde = 1;
                hasta = numElementoPorPagina;
            } else if (paginaActual >= totalPaginas - numElementoPorPagina / 2) {
                desde = totalPaginas - numElementoPorPagina + 1;
                hasta = numElementoPorPagina;
            } else {
                desde = paginaActual - numElementoPorPagina / 2;
                hasta = numElementoPorPagina;
            }

            for (int i = 0; i < hasta; i++) {
                paginas.add(new PageItem(desde + 1, paginaActual == desde + 1));
            }
        }
    }

    public  boolean isFirst(){
        return page.isFirst();
    }

    public boolean isLast(){
        return  page.isLast();
    }

    public boolean isHastNext(){
        return page.hasNext();
    }

    public boolean isHasPrevious(){
        return  page.hasPrevious();
    }
}
