package com.stock.inventario.services;

import com.stock.inventario.dao.IProveedorDao;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceProveedor implements IObjectQuery<Proveedor> {

    @Autowired
    IProveedorDao proveedorDao;

    @Override
    public void create(Proveedor proveedor) throws Exception {
        proveedorDao.save(proveedor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> findAll() throws Exception {
        return (List<Proveedor>) proveedorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedor findById(Long id) throws Exception {
        return proveedorDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(Proveedor proveedor) throws Exception {
        proveedorDao.save(proveedor);
    }

    @Override
    public void delete(Proveedor proveedor) throws Exception {
        proveedorDao.delete(proveedor);
    }

    @Override
    public List<Proveedor> findAll(int valor) throws Exception {
        return null;
    }

    public void inactive(Proveedor proveedor) throws Exception {
        proveedor.setEstado(false);
        proveedorDao.save(proveedor);
    }
    
}
