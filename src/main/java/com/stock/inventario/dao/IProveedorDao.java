package com.stock.inventario.dao;

import com.stock.inventario.model.Proveedor;
import org.springframework.data.repository.CrudRepository;

public interface IProveedorDao extends CrudRepository<Proveedor, Integer> {

}
