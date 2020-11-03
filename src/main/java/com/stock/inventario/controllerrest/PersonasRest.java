package com.stock.inventario.controllerrest;


import com.stock.inventario.dto.PersonaCliente;
import com.stock.inventario.dto.PersonaEmpleado;
import com.stock.inventario.services.ServiceEmpleado;
import com.stock.inventario.services.ServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/personRestApi")
public class PersonasRest {

    @Autowired
    ServicePersona servicePersona;

    @Autowired
    ServiceEmpleado serviceEmpleado;


    @GetMapping(value = "listEmplooyed")
    public List<PersonaEmpleado> listPersonEmployed(){
        List<PersonaEmpleado> empleados = new ArrayList<PersonaEmpleado>();

        try {
            empleados = serviceEmpleado.findAllPersonEmploye();
        }catch (Exception e){
            empleados = null;
        }

        return empleados;
    }

    @GetMapping(value = "listPersonRest")
    public @ResponseBody List<PersonaCliente> listClient(){
        List<PersonaCliente> pc = new ArrayList<PersonaCliente>();

        try {
            pc = servicePersona.personaClienteFindAll();
        }catch (Exception e){
            pc = new ArrayList<PersonaCliente>();
        }

        return pc;
    }
}
