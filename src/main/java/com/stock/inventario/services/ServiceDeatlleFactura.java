package com.stock.inventario.services;

import com.stock.inventario.dao.IDetalleFacturaDao;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.DetalleFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDeatlleFactura implements IObjectQuery<DetalleFactura> {


   @Autowired
   IDetalleFacturaDao iDetalleFacturaDao;

    @Override
    public void create(DetalleFactura detalleFactura) throws Exception {
      iDetalleFacturaDao.save(detalleFactura);
    }

    @Override
    public List<DetalleFactura> findAll() throws Exception {
        return (List<DetalleFactura>) iDetalleFacturaDao.findAll();
    }

    @Override
    public DetalleFactura findById(Long id) throws Exception {
        return iDetalleFacturaDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(DetalleFactura detalleFactura) throws Exception {

    }

    @Override
    public void delete(DetalleFactura detalleFactura) throws Exception {

    }

    @Override
    public List<DetalleFactura> findAll(int valor) throws Exception {
        return null;
    }
}
