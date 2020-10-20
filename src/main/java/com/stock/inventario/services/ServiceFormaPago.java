package com.stock.inventario.services;

import com.stock.inventario.dao.IFormaPagoDao;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.FormaPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceFormaPago implements IObjectQuery<FormaPago> {

    @Autowired
    IFormaPagoDao formaPagoDao;

    @Override
    public void create(FormaPago formaPago) throws Exception {
        formaPagoDao.save(formaPago);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FormaPago> findAll() throws Exception {
        return (List<FormaPago>) formaPagoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public FormaPago findById(Long id) throws Exception {
        return formaPagoDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(FormaPago formaPago) throws Exception {
        formaPagoDao.save(formaPago);
    }

    @Override
    public void delete(FormaPago formaPago) throws Exception {
        formaPagoDao.delete(formaPago);
    }

    @Override
    public List<FormaPago> findAll(int valor) throws Exception {
        return null;
    }
}
