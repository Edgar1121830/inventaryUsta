package com.stock.inventario.services;

import com.stock.inventario.dao.IEmpleadoDao;
import com.stock.inventario.dao.IPersonaDao;
import com.stock.inventario.dto.PersonaEmpleado;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Empleado;
import com.stock.inventario.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServiceEmpleado implements IObjectQuery<Empleado> {

    @Autowired
    IEmpleadoDao empleadoDao;

    @Autowired
    IPersonaDao personaDao;

    @Override
    public void create(Empleado empleado) throws Exception {
        empleadoDao.save(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> findAll() throws Exception {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado findById(Long id) throws Exception {
        return empleadoDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(Empleado empleado) throws Exception {
        empleadoDao.save(empleado);
    }

    public void inactive(Empleado empleado) throws Exception {
        empleado.setEstado(false);
        empleadoDao.save(empleado);
    }
    
    @Override
    public void delete(Empleado empleado) throws Exception {
        empleadoDao.delete(empleado);
    }

    @Override
    public List<Empleado> findAll(int valor) throws Exception {
        return null;
    }

    public List<PersonaEmpleado> findAllPersonEmploye() throws Exception{
        List<PersonaEmpleado> empleados = new ArrayList<PersonaEmpleado>();

        List<Object[]> listResult = personaDao.findallPersonEmpleado();
        if(listResult.size()>0){
            for(Object[] ob : listResult){
                Persona persona = new Persona();
                Empleado empleado = new Empleado();

                persona.setIdPersona((Integer) ob[0]);
                persona.setDocumento((Long) ob[1]);
                persona.setDireccion(((String) ob[2]).trim().toUpperCase());
                persona.setFechaNacimiento((Date) ob[3]);
                persona.setGenero((String) ob[4]);
                persona.setPrimerApellido(((String) ob[5]).trim().toUpperCase());
                persona.setSegundoApellido(((String) ob[6]).trim().toUpperCase());
                persona.setPrimerNombre(((String) ob[7]).trim().toUpperCase());
                persona.setSegundoNombre(((String) ob[8]).trim().toUpperCase());
                persona.setDireccion(((String) ob[9]).trim());
                persona.setTelefono((Long) ob[10]);
                empleado.setEstado((Boolean)ob[11]);
                empleado.setEmail(((String)ob[12]).trim().toLowerCase());
                empleado.setCargo(((String)ob[13]).trim());
                empleado.setEps(((String)ob[14]).trim());

                PersonaEmpleado personaEmpleado =
                        new PersonaEmpleado(persona,empleado);

                empleados.add(personaEmpleado);

            }
        }else{
            empleados = null;
        }

        return empleados;
    }
}
