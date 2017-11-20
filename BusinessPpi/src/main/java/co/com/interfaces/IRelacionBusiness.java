package co.com.interfaces;

import java.util.List;

import com.co.modelos.Relacion;


public interface IRelacionBusiness {
	
	public void save(Relacion r);
	
	public List<Relacion> list();
	
	public void remove(Relacion r);
}
