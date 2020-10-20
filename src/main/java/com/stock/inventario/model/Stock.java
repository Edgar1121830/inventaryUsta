package com.stock.inventario.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	@Getter
	@Setter
	private Integer idProducto;

	@Getter
	@Setter
	private Integer cantidad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	@Getter
	@Setter
	private Date fechaIngreso;

	@Column(name="precio_costo")
	@Getter
	@Setter
	private double precioCosto;

	@Column(name="precio_venta")
	@Getter
	@Setter
	private double precioVenta;

	public Stock() {
	}

}