package com.co.interfaces;

import java.util.List;
import com.co.modelos.Rol;

public interface IRolDao {
	
	public void save(Rol r);
	
	public void remove(Rol r);
	
	public List<Rol> list();
}
