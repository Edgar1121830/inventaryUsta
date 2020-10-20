package com.stock.inventario.controllerrest;

import com.stock.inventario.model.TipoDocumento;
import com.stock.inventario.model.TipoProducto;
import com.stock.inventario.services.ParameterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inventario/parametizacion")
public class ParametricosRest {


        @Autowired
        ParameterServices parameterServices;

        @GetMapping(value = "/listTypeDocuments")
        public List<TipoDocumento> searchTypeDocument(){
            List<TipoDocumento> documentsType = new ArrayList<>();

            try{
                documentsType = parameterServices.findAll(1);
            }catch (Exception e){
                documentsType = null;
            }

            return documentsType;
        }

        @GetMapping(value = "/listProductType")
        public  List<TipoProducto> listProductType(){
            List<TipoProducto> typeProducts = new ArrayList<>();

            try {
                typeProducts = parameterServices.findAll(2);
            }catch (Exception e){
                typeProducts = null;
            }

            return typeProducts;
        }


}
