package com.stock.inventario.services;

import com.stock.inventario.dao.IPersonaDao;
import com.stock.inventario.dto.PersonaCliente;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Cliente;
import com.stock.inventario.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServicePersona implements IObjectQuery<Persona> {

    @Autowired
    IPersonaDao personaDao;


    @Override
    public void create(Persona persona) throws Exception {
        personaDao.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() throws Exception {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Long id) throws Exception {
        return personaDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(Persona persona) throws Exception {
        personaDao.save(persona);
    }

    @Override
    public void delete(Persona persona) throws Exception {
        personaDao.delete(persona);
    }

    @Override
    public List<Persona> findAll(int valor) throws Exception {
        return null;
    }

    public Persona findPersonByDocument(Long document) throws Exception {
        return personaDao.findByDocumento(document);
    }

    public List<PersonaCliente> personaClienteFindAll() throws Exception {
        List<PersonaCliente> personaCliente = new ArrayList<PersonaCliente>();

        List<Object[]> objects = personaDao.findAllPersonClient();

        if (objects.size() > 0) {
            for (Object[] ob : objects) {
                PersonaCliente cliente = new PersonaCliente();
                Persona p = new Persona();
                Cliente c = new Cliente();
                p.setIdPersona((Integer) ob[0]);
                p.setDocumento((Long) ob[1]);
                p.setDireccion(((String) ob[2]).trim().toUpperCase());
                p.setFechaNacimiento((Date) ob[3]);
                p.setGenero((String) ob[4]);
                p.setPrimerApellido(((String) ob[5]).trim().toUpperCase());
                p.setSegundoApellido(((String) ob[6]).trim().toUpperCase());
                p.setPrimerNombre(((String) ob[7]).trim().toUpperCase());
                p.setSegundoNombre(((String) ob[8]).trim().toUpperCase());
                p.setDireccion(((String) ob[9]).trim());
                p.setTelefono((Long) ob[10]);
                c.setEmail(((String) ob[11]).trim());
                c.setTelefonoContacto((String) ob[12]);
                c.setEstado((Boolean) ob[13]);
                c.setDireccionEntrega(((String) ob[14]).trim());

                cliente.setPersona(p);
                cliente.setCliente(c);

                personaCliente.add(cliente);

            }

        }

        return personaCliente;
    }
}