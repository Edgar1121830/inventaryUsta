package com.stock.inventario.view.xml;

import com.stock.inventario.dto.PersonaCliente;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.xml.MarshallingView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Component
public class ClientListXmlView extends MarshallingView{

    /**
     * metodo que sube a session la transformacion del objeto para mostrarlo
     * como un xml
     * @param model
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        /*quitamos los modelo que se visualizan en el html*/
        model.remove("titulo");
        model.remove("clientsList");

        List<PersonaCliente> perosnaCliente = (List<PersonaCliente>) model.get("clientsList");

        /*se asigna el modelo nuevo a xml*/
        model.put("clientsList", new ClientXmlList(perosnaCliente));

        super.renderMergedOutputModel(model, request, response);
    }
}
