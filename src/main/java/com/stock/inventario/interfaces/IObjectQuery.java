package com.stock.inventario.interfaces;

import java.util.List;

public interface IObjectQuery<T> {


    /**
     * metodo que se encarga de persistir un objeto
     * @param t
     * @throws Exception
     */
    public void create(T t) throws Exception;


    /**
     * metodo que lista la existencias el objeto
     * @return
     * @throws Exception
     */
    public List<T> findAll() throws Exception;

    /**
     * metodo que biusca por el id de la tabla
     * @param id
     * @return
     * @throws Exception
     */
    public T findById(Long id) throws Exception;

    /**
     * actualiza los campos según cambios recibidos
     * @param t
     * @throws Exception
     */
    public void update(T t) throws Exception;

    /**
     * cambia de estado del objeto de activo a inactivo
     * @param t
     * @throws Exception
     */
    public void delete(T t) throws Exception;

    /**
     * metodo que lista la existencias el objeto
     * @return
     * @throws Exception
     */
    public List<T> findAll(int valor) throws Exception;

}