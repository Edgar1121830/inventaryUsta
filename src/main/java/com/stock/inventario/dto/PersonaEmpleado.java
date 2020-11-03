package com.stock.inventario.dto;


import com.stock.inventario.model.Empleado;
import com.stock.inventario.model.Persona;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class PersonaEmpleado implements Serializable{

    @Setter
    @Getter
    private Persona persona;

    @Setter
    @Getter
    private Empleado empleado;

    public PersonaEmpleado() {
        super();
    }

    public PersonaEmpleado(Persona persona, Empleado empleado) {
        this.persona = persona;
        this.empleado = empleado;
    }
}
