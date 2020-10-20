package com.stock.inventario.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name="devoluciones")
public class Devolucion implements Serializable {
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

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_devolcuion")
	@Getter
	@Setter
	@NotNull
	private Date fechaDevolucion;

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
	@Size(min = 3, max = 50)
	private String motivo;

	public Devolucion() {
	}

}