package com.stock.inventario.services;


import com.stock.inventario.dao.ICiudadDao;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceCiudad implements IObjectQuery<Ciudad> {

    @Autowired
    ICiudadDao ciudadDao;

    @Override
    public void create(Ciudad ciudad) throws Exception {
        ciudadDao.save(ciudad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ciudad> findAll() throws Exception {
        return (List<Ciudad>) ciudadDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Ciudad findById(Long id) throws Exception {
        return ciudadDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(Ciudad ciudad) throws Exception {
        ciudadDao.save(ciudad);
    }

    @Override
    public void delete(Ciudad ciudad) throws Exception {
        ciudadDao.delete(ciudad);
    }

    @Override
    public List<Ciudad> findAll(int valor) throws Exception {
        return ciudadDao.buscarMayorCiudadVenta();
    }

}
