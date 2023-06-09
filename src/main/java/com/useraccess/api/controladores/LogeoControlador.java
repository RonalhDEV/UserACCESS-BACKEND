package com.useraccess.api.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.useraccess.api.entidades.Usuario;
import com.useraccess.api.repositorios.UsuarioRepositorio;

@RestController
@CrossOrigin(origins = "*")
public class LogeoControlador {

  @Autowired
  private UsuarioRepositorio UsuarioRepositorio;

  // Controlador para validar el inicio de sesión de un usuario
  @PostMapping("/user/login")
  public ResponseEntity<String> valida(@Validated @RequestBody Usuario usuario) {
    try {
      // Buscar el usuario por su correo electrónico
      Usuario objUser = UsuarioRepositorio.findByEmailUsuario(usuario.getEmailUsuario());
      if (objUser == null) {
        // El usuario no se encontró en la base de datos
        return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
      } else {
        if (objUser.getPasswordUsuario().equals(usuario.getPasswordUsuario())) {
          // Las credenciales son válidas, inicio de sesión exitoso
          return new ResponseEntity<>("Inicio de sesión exitoso", HttpStatus.OK);
        } else {
          // Las credenciales son inválidas
          return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        }
      }
    } catch (Exception e) {
      // Ocurrió un error interno del servidor
      return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
