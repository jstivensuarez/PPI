package com.co.interfaces;

import java.util.List;

import com.co.modelos.Modalidad;

public interface IModalidadDao {

	public void save(Modalidad m);
	
	public void remove(Modalidad m);
	
	public List<Modalidad> list();
}
