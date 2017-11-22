package com.co.interfaces;

import java.util.List;

import com.co.modelos.Relacion;


public interface IRelacionDao {
	
	public void save(Relacion r);
	
	public void remove(Relacion r);
	
	public List<Relacion> list();
}
