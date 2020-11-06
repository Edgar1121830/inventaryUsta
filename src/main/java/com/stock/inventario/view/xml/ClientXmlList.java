package com.stock.inventario.view.xml;

import com.stock.inventario.dto.PersonaCliente;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
/**
 * define las estructura del xml
 * comenzando por la etiqueta cabecera
 */
@XmlRootElement(name = "clientes")
public class ClientXmlList {

    /**
     * define la etiquete que contiene el objeto a mostrar
     */
    @XmlElement(name = "cliente")
    @Getter
    public List<PersonaCliente> personaClientes;

    /**
     * constructor sin parametrizacion
     */
    public ClientXmlList() {
    }

    /**
     * parametrizado
     * @param personaClientes
     */
    public ClientXmlList(List<PersonaCliente> personaClientes) {
        this.personaClientes = personaClientes;
    }
}

