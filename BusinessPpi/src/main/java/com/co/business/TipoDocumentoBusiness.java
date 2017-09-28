package com.co.business;

import java.util.List;

import com.co.dao.TipoDocumentoDao;
import com.co.modelos.TipoDocumento;

import co.com.interfaces.ITipoDocumentoBusiness;

public class TipoDocumentoBusiness implements ITipoDocumentoBusiness {
	
	private TipoDocumentoDao dao;
	public void setDao(TipoDocumentoDao dao) 
    {
		this.dao = dao;
    }
	
	public void save(TipoDocumento t) {
		try{
			dao.save(t);
		}catch(Exception e){
			throw e;
		}
		
	}

	public List<TipoDocumento> list() {
		try{
			return dao.list();
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public void remove(TipoDocumento t) {
		try{
			dao.remove(t);
		}catch(Exception e){
			throw e;
		}	
	}

	
}
