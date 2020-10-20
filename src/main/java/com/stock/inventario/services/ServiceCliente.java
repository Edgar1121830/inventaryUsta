package com.stock.inventario.services;

import com.stock.inventario.dao.IClienteDao;
import com.stock.inventario.interfaces.IObjectQuery;
import com.stock.inventario.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ServiceCliente implements IObjectQuery<Cliente> {
    @Autowired
    IClienteDao clienteDao;

    @Override
    public void create(Cliente cliente) throws Exception {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() throws Exception {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) throws Exception {
        return clienteDao.findById(id.intValue()).orElse(null);
    }

    @Override
    public void update(Cliente cliente) throws Exception {
        clienteDao.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) throws Exception {
        clienteDao.delete(cliente);
    }

    @Override
    public List<Cliente> findAll(int valor) throws Exception {
        return null;
    }

    public void inactive(Cliente cliente) throws Exception {
        cliente.setEstado(false);
        clienteDao.save(cliente);
    }
    
    @Scheduled(cron="0 0 0 1 * *", zone = "America/Bogota")
    public void deleteInactiveClients() throws Exception {
        try {
            Calendar c = Calendar.getInstance();
            c.add((Calendar.MONTH), -6);
            Date initial = c.getTime();

            List<Cliente> clientes = findAll();

            for (Cliente cliente : clientes) {
                if (cliente.getEstado()) {
                    Integer count = clienteDao.countClienteByFechaFacturacion(initial, new Date(), cliente.getIdCliente());
                    if (count == 0) {
                        cliente.setEstado(false);
                        clienteDao.save(cliente);
                        //clienteDao.delete(cliente);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*@Scheduled(cron = "0/10 * * * * *", zone = "America/Bogota")
    public void dele() throws Exception {
        try {
            Calendar c = Calendar.getInstance();
            c.add((Calendar.MONTH), -6);
            Date initial = c.getTime();

            List<Cliente> clientes = clienteDao.countClientesByFechaFacturacion(initial, new Date());

            for (Cliente cliente : clientes) {
                if (cliente.getEstado()) {
                    cliente.setEstado(false);
                    clienteDao.save(cliente);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
