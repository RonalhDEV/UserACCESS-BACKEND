package com.useraccess.api.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.useraccess.api.entidades.Usuario;
import com.useraccess.api.interfaces.Metodos;
import com.useraccess.api.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio implements Metodos<Usuario> {

	@Autowired
	private UsuarioRepositorio UserRepo;

	@Override
	public boolean crearUsuario(Usuario objeto) {
		Usuario objTemporal = UserRepo.save(objeto);
		return objTemporal != null;
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		return UserRepo.findAll();
	}

	@Override
	public boolean eliminarUsuarios(Long id) {
		UserRepo.deleteById(id);
		return !UserRepo.existsById(id);
	}

	@Override
	public boolean actualizarUsuarios(Usuario objeto) {
		Optional<Usuario> objetoVerificado = UserRepo.findById(objeto.getIdUsuario());
		if (!objetoVerificado.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe para actualizar");
		} else {
			UserRepo.save(objeto);
			return true;
		}
	}

	@Override
	public Usuario obtenerUsuario(Long id) {
		return UserRepo.findByIdUsuario(id);
	}
}
