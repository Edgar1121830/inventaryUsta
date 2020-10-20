package com.stock.inventario.dao;

import com.stock.inventario.model.TipoProducto;
import org.springframework.data.repository.CrudRepository;

public interface ITipoProductoDao extends CrudRepository<TipoProducto, Integer> {
}
