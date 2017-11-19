package co.com.interfaces;

import java.util.List;

import com.co.modelos.Modalidad;

public interface IModalidadBusiness {

	public void save(Modalidad m);
	
	public List<Modalidad> list();
	
	public void remove(Modalidad m);
}
