package com.stock.inventario.services;

import com.stock.inventario.dao.IDevolucionDao;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Devolucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceDevolucion implements IObjectQuery<Devolucion> {

    @Autowired
    IDevolucionDao devolucionDao;

    @Override
    public void create(Devolucion devolucion) throws Exception {
        devolucionDao.save(devolucion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Devolucion> findAll() throws Exception {
        return (List<Devolucion>) devolucionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Devolucion findById(Long id) throws Exception {
        return devolucionDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(Devolucion devolucion) throws Exception {
        devolucionDao.save(devolucion);
    }

    @Override
    public void delete(Devolucion devolucion) throws Exception {
        devolucionDao.delete(devolucion);
    }

    @Override
    public List<Devolucion> findAll(int valor) throws Exception {
        return null;
    }
}
