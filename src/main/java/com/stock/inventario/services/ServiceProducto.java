package com.stock.inventario.services;

import com.stock.inventario.dao.IProductoDao;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceProducto implements IObjectQuery<Producto> {

    @Autowired
    IProductoDao productoDao;

    @Override
    public void create(Producto producto) throws Exception {
        productoDao.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() throws Exception {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) throws Exception {
        return productoDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(Producto producto) throws Exception {
        productoDao.save(producto);
    }

    @Override
    public void delete(Producto producto) throws Exception {
        productoDao.delete(producto);
    }

    @Override
    public List<Producto> findAll(int valor) throws Exception {
        return null;
    }

    public void inactive(Producto producto) throws Exception {
        producto.setEstado(false);
        productoDao.save(producto);
    }
    
    /**
     * Método asíncrono que inactiva los productos cuya cantidad en ventas sea menor a 5
     * este método se ejecuta el primer dia de cada mes a la media noche.
     */
    @Scheduled(cron = "0 0 0 1 * *", zone = "America/Bogota")
    public void inactivateProducts() {
        try {
            List<Producto> productos = productoDao.getAllByCantidadMin();

            for (Producto producto : productos) {
                producto.setEstado(false);
                productoDao.save(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
