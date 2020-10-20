package com.stock.inventario.dao;
import com.stock.inventario.model.Ciudad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICiudadDao extends CrudRepository<Ciudad, Integer> {

    @Query("select c, sum(f.total) as total\n" +
            "from Ciudad c, Factura f, Cliente cl, Persona p\n" +
            "where cl.idCliente = p.idPersona\n" +
            "and p.idCiudad = c.idCiudad\n" +
            "and f.idCliente = cl.idCliente\n" +
            "group by c.idCiudad\n" +
            "order by total desc")
    public List<Ciudad> buscarMayorCiudadVenta() throws Exception;

}
