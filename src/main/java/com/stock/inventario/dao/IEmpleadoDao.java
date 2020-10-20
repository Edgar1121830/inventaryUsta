package com.stock.inventario.dao;

import com.stock.inventario.model.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface IEmpleadoDao extends CrudRepository<Empleado, Integer> {

}
