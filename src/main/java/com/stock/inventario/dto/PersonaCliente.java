package com.stock.inventario.dto;

import com.stock.inventario.model.Cliente;
import com.stock.inventario.model.Persona;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedQuery;
import java.io.Serializable;

public class PersonaCliente implements Serializable {

    @Setter
    @Getter
    private Persona persona;

    @Setter
    @Getter
    private Cliente cliente;


    public PersonaCliente() {
    }

    public PersonaCliente(Persona persona, Cliente cliente) {
        this.persona = persona;
        this.cliente = cliente;
    }

}
