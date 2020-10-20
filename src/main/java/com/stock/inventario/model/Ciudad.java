package com.stock.inventario.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ciudades")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ciudad")
	@Getter
	@Setter
	private Integer idCiudad;

	@Column(name="id_departamento")
	@Getter
	@Setter
	@NotNull
	private Integer idDepartamento;

	@Getter
	@Setter
	@NotNull
	@Size(min = 3, max = 50)
	private String nombre;

	public Ciudad() {
	}


}