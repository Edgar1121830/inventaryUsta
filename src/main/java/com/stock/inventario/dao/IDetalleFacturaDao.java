package com.stock.inventario.dao;

import com.stock.inventario.model.DetalleFactura;
import org.springframework.data.repository.CrudRepository;

public interface IDetalleFacturaDao extends CrudRepository<DetalleFactura, Integer> {

}
