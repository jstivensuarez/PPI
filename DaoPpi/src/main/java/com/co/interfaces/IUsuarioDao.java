package com.co.interfaces;

import java.util.List;

import com.co.modelos.Usuario;

public interface IUsuarioDao {
	
	public void save(Usuario t);

	public void remove(Usuario t);

	public List<Usuario> list();
}
