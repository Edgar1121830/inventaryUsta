package com.stock.inventario.services;

import com.stock.inventario.dao.IEmpleadoDao;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceEmpleado implements IObjectQuery<Empleado> {

    @Autowired
    IEmpleadoDao empleadoDao;

    @Override
    public void create(Empleado empleado) throws Exception {
        empleadoDao.save(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> findAll() throws Exception {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado findById(Long id) throws Exception {
        return empleadoDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(Empleado empleado) throws Exception {
        empleadoDao.save(empleado);
    }

    public void inactive(Empleado empleado) throws Exception {
        empleado.setEstado(false);
        empleadoDao.save(empleado);
    }
    
    @Override
    public void delete(Empleado empleado) throws Exception {
        empleadoDao.delete(empleado);
    }

    @Override
    public List<Empleado> findAll(int valor) throws Exception {
        return null;
    }
}
