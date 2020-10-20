package com.stock.inventario.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	@Getter
	@Setter
	private Integer idProducto;

	@Getter
	@Setter
	private String descripcion;

	@Getter
	@Setter
	private Boolean estado;

	@Column(name="id_proveedor")
	@Getter
	@Setter
	@NotNull
	private Integer idProveedor;

	@Column(name="id_tipo")
	@Getter
	@Setter
	@NotNull
	private Integer idTipo;

	@Getter
	@Setter
	@Size(min = 3, max = 50)
	private String nombre;

	public Producto() {
	}

}