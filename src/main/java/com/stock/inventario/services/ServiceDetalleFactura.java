package com.stock.inventario.services;


import com.stock.inventario.dao.IDetalleFacturaDao;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.DetalleFactura;
import com.stock.inventario.model.Producto;
import com.stock.inventario.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceDetalleFactura implements IObjectQuery<DetalleFactura> {

    @Autowired
    IDetalleFacturaDao detalleFacturaDao;

    @Override
    public void create(DetalleFactura detalleFactura) throws Exception {
        detalleFacturaDao.save(detalleFactura);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetalleFactura> findAll() throws Exception {
        return (List<DetalleFactura>) detalleFacturaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleFactura findById(Long id) throws Exception {
        return detalleFacturaDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(DetalleFactura detalleFactura) throws Exception {
        detalleFacturaDao.save(detalleFactura);
    }
    
    @Override
    public void delete(DetalleFactura detalleFactura) throws Exception {
        detalleFacturaDao.delete(detalleFactura);
    }

    @Override
    public List<DetalleFactura> findAll(int valor) throws Exception {
        return null;
    }


    public List<DetalleFactura> calcularValorTotalFactura(List<Stock> productos){
        List<DetalleFactura> detalleFacturas= new ArrayList<DetalleFactura>();
        Double iva = 19.0;
        Double resultado = 0.0;
        Double facturaTotal = 0.0;
        DetalleFactura f = new DetalleFactura();

        if(productos.size()>0) {
            for (Stock p : productos) {
                resultado = resultado + p.getPrecioVenta();

                if (resultado > 0) {
                    double facturaTotalIva = resultado * (iva / 100);

                    facturaTotal = resultado + facturaTotalIva;
                    f.setTotal(facturaTotal);
                }

                detalleFacturas.add(f);
            }
        }
       return  detalleFacturas;
    }
}
