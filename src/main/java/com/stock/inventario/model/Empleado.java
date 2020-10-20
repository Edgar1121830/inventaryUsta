package com.stock.inventario.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="empleados")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empleado")
	@Getter
	@Setter
	private Integer idEmpleado;

	@Getter
	@Setter
	private Boolean estado;

	@Getter
	@Setter
	@NotNull
	@Email
	@Size(min=10, max=50)
	private String email;

	@Getter
	@Setter
	@NotNull
	@Size(min=5, max=50)
	private String cargo;

	@Getter
	@Setter
	@NotNull
	@Size(min=5, max=50)
	private String eps;

	public Empleado() {
	}

}