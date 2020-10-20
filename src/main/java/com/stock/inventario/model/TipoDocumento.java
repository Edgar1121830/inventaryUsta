package com.stock.inventario.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="tipos_documentos")
public class TipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo")
	@Getter
	@Setter
	private Integer idTipo;

	@Getter
	@Setter
	@Size(min = 2, max = 50)
	private String nombre;

	public TipoDocumento() {
	}

}