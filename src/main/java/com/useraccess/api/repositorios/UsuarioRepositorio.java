package com.useraccess.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.useraccess.api.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	public Usuario findByEmailUsuario(String emailUsuario);

	public Usuario findByIdUsuario(Long idUsuario);
}
