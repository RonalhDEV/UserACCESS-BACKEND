package com.useraccess.api.interfaces;

import java.util.List;

public interface Metodos<U> {
	
	public abstract boolean crearUsuario(U objeto);
	
	public abstract List<U> obtenerUsuarios();
	
	public abstract boolean eliminarUsuarios(Long id);
	
	public abstract boolean actualizarUsuarios(U objeto);
	
	public abstract U obtenerUsuario(Long id);
}
