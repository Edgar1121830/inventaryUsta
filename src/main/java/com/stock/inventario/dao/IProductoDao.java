package com.stock.inventario.dao;

import com.stock.inventario.model.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductoDao extends CrudRepository<Producto, Integer> {

    @Query("select p " +
            "from Stock s " +
            "left join DetalleFactura df on df.idProducto = s.idProducto " +
            "inner join Producto p on p.idProducto = s.idProducto " +
            "inner join Factura f on f.idFactura = df.idFactura " +
            "group by p.idProducto " +
            "having p.estado = true and (sum(df.cantidad) < 5 or sum(df.cantidad) is null)")
    public List<Producto> getAllByCantidadMin() throws Exception;

}

