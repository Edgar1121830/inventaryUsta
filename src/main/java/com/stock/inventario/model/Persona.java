package com.stock.inventario.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="personas")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona")
	@Getter
	@Setter
	private Integer idPersona;

	@Getter
	@Setter
	private String direccion;

	@Getter
	@Setter
	@NotNull
	private Long documento;

	@Column(name="id_ciudad")
	@Getter
	@Setter
	private Integer idCiudad;

	@Column(name="id_tipo")
	@Getter
	@Setter
	@NotNull
	private Integer idTipo;

	@Column(name="primer_apellido")
	@Getter
	@Setter
	@Size(min = 3, max = 50)
	private String primerApellido;

	@Column(name="primer_nombre")
	@Getter
	@Setter
	@Size(min = 3, max = 50)
	private String primerNombre;

	@Column(name="segundo_apellido")
	@Getter
	@Setter
	@Size(max = 50)
	private String segundoApellido;

	@Column(name="segundo_nombre")
	@Getter
	@Setter
	@Size( max = 50)
	private String segundoNombre;

	@Getter
	@Setter
	private Long telefono;

	@Getter
	@Setter
	@NotNull
	@Size(min=1, max=2)
	private String genero;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimientos")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Setter
	@Getter
	private Date fechaNacimiento;

	public Persona() {
	}

}