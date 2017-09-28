package com.co.interfaces;

import java.util.List;

import com.co.modelos.TipoDocumento;

public interface ITipoDocumentoDao {
	
	public void save(TipoDocumento t);
	
	public void remove(TipoDocumento t);
	
	public List<TipoDocumento> list();
	
	
}
