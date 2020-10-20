package com.stock.inventario.dao;

import com.stock.inventario.model.Departamento;
import org.springframework.data.repository.CrudRepository;

public interface IDepartamentoDao extends CrudRepository<Departamento, Integer> {

}
