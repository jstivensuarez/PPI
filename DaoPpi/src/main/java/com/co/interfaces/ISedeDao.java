package com.co.interfaces;

import java.util.List;

import com.co.modelos.Sede;

public interface ISedeDao {
	
	public void save(Sede s);
	
	public void remove(Sede s);
	
	public List<Sede> list();
}
