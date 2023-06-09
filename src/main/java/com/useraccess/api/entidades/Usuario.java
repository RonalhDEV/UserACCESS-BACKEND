package com.useraccess.api.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

// La anotación @Entity indica que esta clase es una entidad persistente en la base de datos
@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "emailUsuario"))
public class Usuario {

	// La anotación @Id indica que el campo idUsuario es la clave primaria de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private Long idUsuario;

	// El campo emailUsuario se mapea a la columna correspondiente en la tabla usuario
	@Column(name = "emailUsuario", nullable = false)
	private String emailUsuario;

	// El campo passwordUsuario se mapea a la columna correspondiente en la tabla usuario
	@Column(name = "passwordUsuario", nullable = false)
	private String passwordUsuario;

	// Constructor predeterminado de la clase Usuario
	public Usuario() {
	}

	// Getter y Setter para el campo idUsuario
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	// Getter y Setter para el campo emailUsuario
	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	// Getter y Setter para el campo passwordUsuario
	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}
}
