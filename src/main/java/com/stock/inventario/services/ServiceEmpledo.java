package com.stock.inventario.services;

import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Empleado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmpledo implements IObjectQuery<Empleado> {


    @Override
    public void create(Empleado empleado) throws Exception {

    }

    @Override
    public List<Empleado> findAll() throws Exception {
        return null;
    }

    @Override
    public Empleado findById(Long id) throws Exception {
        return null;
    }

    @Override
    public void update(Empleado empleado) throws Exception {

    }

    @Override
    public void delete(Empleado empleado) throws Exception {

    }

    @Override
    public List<Empleado> findAll(int valor) throws Exception {
        return null;
    }
}
