package com.stock.inventario.dao;

import com.stock.inventario.model.Devolucion;
import org.springframework.data.repository.CrudRepository;

public interface IDevolucionDao extends CrudRepository<Devolucion, Integer> {

}
