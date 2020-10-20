package com.stock.inventario.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="detalle_facturas")
public class DetalleFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle")
	@Getter
	@Setter
	private Integer idDetalle;

	@Getter
	@Setter
	@NotNull
	private Integer cantidad;

	@Column(name="id_factura")
	@Getter
	@Setter
	@NotNull
	private Integer idFactura;

	@Column(name="id_producto")
	@Getter
	@Setter
	@NotNull
	private Integer idProducto;

	@Getter
	@Setter
	private double total;

	public DetalleFactura() {
	}


}