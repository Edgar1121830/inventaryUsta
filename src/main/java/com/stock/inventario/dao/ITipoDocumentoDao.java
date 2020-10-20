package com.stock.inventario.dao;

import com.stock.inventario.model.TipoDocumento;
import org.springframework.data.repository.CrudRepository;

public interface ITipoDocumentoDao extends CrudRepository<TipoDocumento, Integer> {

}
