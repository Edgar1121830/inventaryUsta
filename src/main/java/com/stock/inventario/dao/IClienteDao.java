package com.stock.inventario.dao;

import com.stock.inventario.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface IClienteDao extends CrudRepository<Cliente, Integer> {

    @Query("select count(idFactura) from Factura where fechaFacturacion between ?1 and ?2 and idCliente=?3")
    public Integer countClienteByFechaFacturacion(Date inicio, Date fin, Integer id) throws Exception;


}
