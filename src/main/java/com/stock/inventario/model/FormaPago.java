package com.stock.inventario.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="formas_pagos")
public class FormaPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_forma_pago")
	@Getter
	@Setter
	private Integer idFormaPago;

	@Getter
	@Setter
	@Size(min = 3, max = 50)
	private String descripcion;

	public FormaPago() {
	}

}