package co.com.interfaces;

import java.util.List;

import com.co.modelos.Alumno;

public interface IAlumnoBusiness {
	
	public void save(Alumno a);
	
	public List<Alumno> list();
		
	public void remove(Alumno a);
}
