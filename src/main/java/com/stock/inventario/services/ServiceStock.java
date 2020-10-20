package com.stock.inventario.services;

import com.stock.inventario.dao.IStockDao;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceStock implements IObjectQuery<Stock> {

    @Autowired
    IStockDao stockDao;

    @Override
    public void create(Stock stock) throws Exception {
        stockDao.save(stock);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Stock> findAll() throws Exception {
        return (List<Stock>) stockDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Stock findById(Long id) throws Exception {
        return stockDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(Stock stock) throws Exception {
        stockDao.save(stock);
    }

    @Override
    public void delete(Stock stock) throws Exception {
        stockDao.delete(stock);
    }

    @Override
    public List<Stock> findAll(int valor) throws Exception {
        return null;
    }
}
