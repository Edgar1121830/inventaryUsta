package com.stock.inventario.services;

import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Devolucion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesDevolucion implements IObjectQuery<Devolucion> {
    @Override
    public void create(Devolucion devolucion) throws Exception {

    }

    @Override
    public List<Devolucion> findAll() throws Exception {
        return null;
    }

    @Override
    public Devolucion findById(Long id) throws Exception {
        return null;
    }

    @Override
    public void update(Devolucion devolucion) throws Exception {

    }

    @Override
    public void delete(Devolucion devolucion) throws Exception {

    }

    @Override
    public List<Devolucion> findAll(int valor) throws Exception {
        return null;
    }
}
