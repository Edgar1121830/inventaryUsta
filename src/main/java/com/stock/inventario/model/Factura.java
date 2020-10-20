package com.stock.inventario.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name="facturas")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura")
	@Getter
	@Setter
	private Integer idFactura;

	@Getter
	@Setter
	private Boolean estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_facturacion")
	@Getter
	@Setter
	@NotNull
	private Date fechaFacturacion;

	@Column(name="id_cliente")
	@Getter
	@Setter
	@NotNull
	private Integer idCliente;

	@Column(name="id_empleado")
	@Getter
	@Setter
	@NotNull
	private Integer idEmpleado;

	@Column(name="id_forma_pago")
	@Getter
	@Setter
	@NotNull
	private Integer idFormaPago;

	@Getter
	@Setter
	@NotNull
	private BigDecimal iva;

	@Getter
	@Setter
	private double total;

	public Factura() {
	}

}