package com.useraccess.api.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.useraccess.api.entidades.Usuario;
import com.useraccess.api.servicios.UsuarioServicio;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class RegistroControlador {
	
	@Autowired
	UsuarioServicio UserServi;
	
	// Endpoint para crear un usuario
	@ResponseStatus(code = HttpStatus.CREATED, reason = "¡Usuario creado!")
	@RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = "application/json")
	public Usuario crearUser(@RequestBody Usuario objUser) {
		UserServi.crearUsuario(objUser);
		return objUser;
	}
	
	// Endpoint para obtener todos los usuarios
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public List<Usuario> obtenerUser() {
		return UserServi.obtenerUsuarios();
	}
	
	// Endpoint para eliminar un usuario por su ID
	@ResponseStatus(code = HttpStatus.OK, reason = "¡Usuario eliminado!")
	@RequestMapping(value = "/borrar/{id}", method = RequestMethod.DELETE)
	public void borrarUser(@PathVariable Long id) {
		UserServi.eliminarUsuarios(id);
	}
	
	// Endpoint para actualizar un usuario
	@ResponseStatus(code = HttpStatus.ACCEPTED, reason = "¡Usuario actualizado!")
	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
	public void actualizarUser(@RequestBody Usuario objUser) {
		UserServi.actualizarUsuarios(objUser);
	}
	
	// Endpoint para obtener un usuario por su ID
	@RequestMapping(value = "obtener/{id}", method = RequestMethod.GET)
    public Usuario obtenerUserPorId(@PathVariable Long id) {
        return UserServi.obtenerUsuario(id);
    }
}
