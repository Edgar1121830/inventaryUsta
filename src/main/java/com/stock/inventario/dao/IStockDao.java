package com.stock.inventario.dao;

import com.stock.inventario.model.Stock;
import org.springframework.data.repository.CrudRepository;

public interface IStockDao extends CrudRepository<Stock, Integer> {

}
