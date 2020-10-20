package com.stock.inventario.services;

import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Ciudad;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesCiudad implements IObjectQuery<Ciudad> {


    @Override
    public void create(Ciudad ciudad) throws Exception {

    }

    @Override
    public List<Ciudad> findAll() throws Exception {
        return null;
    }

    @Override
    public Ciudad findById(Long id) throws Exception {
        return null;
    }

    @Override
    public void update(Ciudad t) throws Exception {

    }

    @Override
    public void delete(Ciudad t) throws Exception {

    }

    @Override
    public List<Ciudad> findAll(int valor) throws Exception {
        return null;
    }
}
