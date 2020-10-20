package com.stock.inventario.dao;

import com.stock.inventario.model.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura, Integer> {

}
