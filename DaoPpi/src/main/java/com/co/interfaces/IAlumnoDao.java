package com.co.interfaces;

import java.util.List;

import com.co.modelos.Alumno;

public interface IAlumnoDao {
	
	public void save(Alumno a);
	
	public void remove(Alumno a);
	
	public List<Alumno> list();
}
