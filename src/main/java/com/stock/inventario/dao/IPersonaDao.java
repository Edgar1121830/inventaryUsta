package com.stock.inventario.dao;

import com.stock.inventario.dto.PersonaCliente;
import com.stock.inventario.model.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonaDao extends CrudRepository<Persona, Integer> {

    @Query("select p from Persona p where p.documento=?1")
    public Persona findByDocumento(Long document);

    @Query("select p.idPersona, p.documento, p.direccion, p.fechaNacimiento, " +
            "p.genero, p.primerApellido, p.segundoApellido, " +
            "p.primerNombre, p.segundoNombre, p.direccion,p.telefono, " +
            "c.telefonoContacto, c.email, c.estado, c.direccionEntrega  " +
            "from Persona p, Cliente c where c.idCliente = p.idPersona" )
    public List<Object[]> findAllPersonClient();


}
