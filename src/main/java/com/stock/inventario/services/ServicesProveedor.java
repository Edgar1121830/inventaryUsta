package com.stock.inventario.services;

import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Proveedor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesProveedor implements IObjectQuery<Proveedor> {
    @Override
    public void create(Proveedor proveedor) throws Exception {

    }

    @Override
    public List<Proveedor> findAll() throws Exception {
        return null;
    }

    @Override
    public Proveedor findById(Long id) throws Exception {
        return null;
    }

    @Override
    public void update(Proveedor proveedor) throws Exception {

    }

    @Override
    public void delete(Proveedor proveedor) throws Exception {

    }

    @Override
    public List<Proveedor> findAll(int valor) throws Exception {
        return null;
    }
}
