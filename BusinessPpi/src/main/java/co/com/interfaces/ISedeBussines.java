package co.com.interfaces;

import java.util.List;

import com.co.modelos.Sede;



public interface ISedeBussines {
	
	public void save(Sede s);
	
	public List<Sede> list();
	
	public void remove(Sede s);
}
