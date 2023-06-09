package com.useraccess.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.useraccess.api.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	// Método para buscar un usuario por su emailUsuario
	// Recibe un emailUsuario como parámetro y devuelve un objeto de tipo Usuario
	public Usuario findByEmailUsuario(String emailUsuario);

	// Método para buscar un usuario por su idUsuario
	// Recibe un idUsuario como parámetro y devuelve un objeto de tipo Usuario
	public Usuario findByIdUsuario(Long idUsuario);
}
