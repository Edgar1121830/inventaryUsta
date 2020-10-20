package com.stock.inventario.unitarias;


import com.stock.inventario.model.DetalleFactura;
import com.stock.inventario.model.Stock;
import com.stock.inventario.services.ServiceDetalleFactura;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)
public class DetalleFacturaTest {

    private List<Stock> stocks;
    List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();

    @Mock //instanciar el servicio o dao
    ServiceDetalleFactura serviceDetalleFactura;

    //se ecarga de prepar los datos de prueba
    @Before
    public void initDate(){

        serviceDetalleFactura = new ServiceDetalleFactura();
        stocks = new ArrayList<>();
        Stock stock = new Stock();
        Stock stock1 = new Stock();

        stock.setPrecioVenta(3000);
        stock.setCantidad(10);
        stock.setFechaIngreso(new Date());
        stock.setIdProducto(1);
        stock.setPrecioCosto(2000);



        stock1.setPrecioVenta(3000);
        stock1.setCantidad(5);
        stock1.setFechaIngreso(new Date());
        stock1.setIdProducto(2);
        stock1.setPrecioCosto(2000);

        stocks.add(stock);
        stocks.add(stock1);
    }

    //son los metodos que se ejecutan al momento de crear una logica
    //que no cuenta con un cliente sino depende de un proceso que lo invoque
    @Test
    public void calculoTotalFactura(){

        detalleFacturas =serviceDetalleFactura.calcularValorTotalFactura(stocks);
        Assert.isTrue(detalleFacturas.size()>0);
        //Mockito.when(detalleFacturas).equals(detalleFacturas);
    }

    @Test
    public void sumaTotal(){
        Assert.isTrue(detalleFacturas.size()>0);
    }

}
