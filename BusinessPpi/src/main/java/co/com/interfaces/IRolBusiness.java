package co.com.interfaces;

import java.util.List;

import com.co.modelos.Rol;

public interface IRolBusiness {
	
	public void save(Rol r);
	
	public List<Rol> list();
	
	public void remove(Rol r);
}
