package com.co.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.interfaces.IAlumnoDao;
import com.co.modelos.Alumno;

import co.com.interfaces.IAlumnoBusiness;

@Service("busAlu")
public class AlumnoBusiness implements IAlumnoBusiness{

	@Autowired
	private IAlumnoDao daoAlu;
	
	public void save(Alumno a) {
		try {
			daoAlu.save(a);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Alumno> list(){
		try {
			return daoAlu.list();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void remove(Alumno a) {
		try {
			daoAlu.remove(a);
		} catch (Exception e) {
			throw e;
		}
	}
		
	public String descripcionSede(int idAlumno) {
		String descripcion;
		try {
			descripcion = daoAlu.descripcionSede(idAlumno);
			return descripcion;
		} catch (Exception e) {
			throw e;
		}
		
	}
}
