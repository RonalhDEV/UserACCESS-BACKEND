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

	// Método para crear un usuario
	// Recibe un objeto de tipo Usuario y devuelve un booleano indicando si se ha creado correctamente
	@Override
	public boolean crearUsuario(Usuario objeto) {
		Usuario objTemporal = UserRepo.save(objeto);
		return objTemporal != null;
	}

	// Método para obtener todos los usuarios
	// Devuelve una lista de objetos de tipo Usuario
	@Override
	public List<Usuario> obtenerUsuarios() {
		return UserRepo.findAll();
	}

	// Método para eliminar un usuario por su id
	// Recibe un id como parámetro y devuelve un booleano indicando si se ha eliminado correctamente
	@Override
	public boolean eliminarUsuarios(Long id) {
		UserRepo.deleteById(id);
		return !UserRepo.existsById(id);
	}

	// Método para actualizar un usuario
	// Recibe un objeto de tipo Usuario y devuelve un booleano indicando si se ha actualizado correctamente
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

	// Método para obtener un usuario por su id
	// Recibe un id como parámetro y devuelve un objeto de tipo Usuario
	@Override
	public Usuario obtenerUsuario(Long id) {
		return UserRepo.findByIdUsuario(id);
	}
}