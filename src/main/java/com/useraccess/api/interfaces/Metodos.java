package com.useraccess.api.interfaces;

import java.util.List;

// La interfaz Metodos define una serie de métodos para operaciones básicas en una entidad genérica U
public interface Metodos<U> {

	// Método abstracto para crear un objeto de tipo U
	// Recibe un objeto como parámetro y devuelve un booleano indicando si la operación fue exitosa
	public abstract boolean crearUsuario(U objeto);
	
	// Método abstracto para obtener una lista de objetos de tipo U
	// Devuelve una lista de objetos de tipo U
	public abstract List<U> obtenerUsuarios();
	
	// Método abstracto para eliminar un objeto de tipo U por su ID
	// Recibe un ID como parámetro y devuelve un booleano indicando si la operación fue exitosa
	public abstract boolean eliminarUsuarios(Long id);
	
	// Método abstracto para actualizar un objeto de tipo U
	// Recibe un objeto como parámetro y devuelve un booleano indicando si la operación fue exitosa
	public abstract boolean actualizarUsuarios(U objeto);
	
	// Método abstracto para obtener un objeto de tipo U por su ID
	// Recibe un ID como parámetro y devuelve un objeto de tipo U
	public abstract U obtenerUsuario(Long id);
}
