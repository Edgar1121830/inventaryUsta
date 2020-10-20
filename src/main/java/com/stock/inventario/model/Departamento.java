package com.stock.inventario.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name="departamentos")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_departamento")
	@Getter
	@Setter
	private Integer idDepartamento;

	@Getter
	@Setter
	@Size(min = 3, max = 50)
	private String nombre;

	public Departamento() {
	}

}