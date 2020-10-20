package com.stock.inventario.services;

import com.stock.inventario.dao.IDepartamentoDao;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceDepartamento implements IObjectQuery<Departamento> {
    @Autowired
    IDepartamentoDao departamentoDao;

    @Override
    public void create(Departamento departamento) throws Exception {
        departamentoDao.save(departamento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> findAll() throws Exception {
        return (List<Departamento>) departamentoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Departamento findById(Long id) throws Exception {
        return departamentoDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(Departamento departamento) throws Exception {
        departamentoDao.save(departamento);
    }

    @Override
    public void delete(Departamento departamento) throws Exception {
        departamentoDao.delete(departamento);
    }

    @Override
    public List<Departamento> findAll(int valor) throws Exception {
        return null;
    }
}
