package com.stock.inventario.services;

import com.stock.inventario.dao.IFacturaDao;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Factura;
import com.stock.inventario.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceFactura implements IObjectQuery<Factura> {

    @Autowired
    IFacturaDao facturaDao;

    @Override
    public void create(Factura factura) throws Exception {
        facturaDao.save(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Factura> findAll() throws Exception {
        return (List<Factura>) facturaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findById(Long id) throws Exception {
        return facturaDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(Factura factura) throws Exception {
        facturaDao.save(factura);
    }

    @Override
    public void delete(Factura factura) throws Exception {
        facturaDao.delete(factura);
    }

    @Override
    public List<Factura> findAll(int valor) throws Exception {
        return null;
    }


}
