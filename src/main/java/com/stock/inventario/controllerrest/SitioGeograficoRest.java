package com.stock.inventario.controllerrest;

import com.stock.inventario.model.Ciudad;
import com.stock.inventario.services.ServiceCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inventario/gregrafia")
public class SitioGeograficoRest {

    @Autowired
    ServiceCiudad serviceCiudad;

    @GetMapping(value = "/maxSave")
    public List<Ciudad> searchCityMaxSave(){
        List<Ciudad> c = new ArrayList<>();
        try {
            c = serviceCiudad.findAll(0);
        }catch (Exception e){
            c = null;
        }
        return c;
    }

}
