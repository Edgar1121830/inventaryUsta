package com.stock.inventario.services;

import com.stock.inventario.dao.IProductoDao;
import com.stock.inventario.dao.ITipoDocumentoDao;
import com.stock.inventario.dao.ITipoProductoDao;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Producto;
import com.stock.inventario.model.TipoDocumento;
import com.stock.inventario.model.TipoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParameterServices<T> implements IObjectQuery<T>  {

    @Autowired
    ITipoDocumentoDao iTipoDocumentoDao;

    @Autowired
    ITipoProductoDao iProductoDao;

    @Override
    public void create(T t) throws Exception {

    }

    @Override
    public List<T> findAll() throws Exception {
        return null;
    }

    @Override
    public T findById(Long id) throws Exception {
        return null;
    }

    @Override
    public void update(T t) throws Exception {

    }

    @Override
    public void delete(T t) throws Exception {

    }

    @Override
    public List<T> findAll(int valor) throws Exception {
        List<TipoDocumento> tpDoc = new ArrayList<>();
        List<TipoProducto> product  = new ArrayList<>();
        List<T> obList = new ArrayList<>();
       switch (valor){
           case 1:
               tpDoc = (List<TipoDocumento>) iTipoDocumentoDao.findAll();
               obList = (List<T>) tpDoc;
               break;
           case 2:
               product = (List<TipoProducto>) iProductoDao.findAll();
               obList = (List<T>) product;
               break;
           default:
               obList = null;
               break;

       }
        return obList;
    }
}
