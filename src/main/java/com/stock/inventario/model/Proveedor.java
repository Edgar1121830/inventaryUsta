package com.stock.inventario.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="proveedores")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_proveedor")
	@Getter
	@Setter
	private Integer idProveedor;

	@Getter
	@Setter
	private Boolean estado;

	@Getter
	@Setter
	@NotNull
	private Integer nit;

	@Column(name="nombre_comercial")
	@Getter
	@Setter
	@Size(min = 3, max = 50)
	private String nombreComercial;

	public Proveedor() {
	}

}