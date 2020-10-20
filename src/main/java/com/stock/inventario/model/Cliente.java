package com.stock.inventario.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	@Getter
	@Setter
	private Integer idCliente;

	@Getter
	@Setter
	@Email
	@Size(min=10, max=50)
	private String email;

	@Getter
	@Setter
	@Column(name="telefono_contacto")
	@Size(max=50)
	private String telefonoContacto;

	@Getter
	@Setter
	@Size(max=50)
	@Column(name="direccion_entrega")
	private String direccionEntrega;

	@Getter
	@Setter
	private Boolean estado;

	public Cliente() {
	}

}