package com.co.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.co.interfaces.ITipoDocumentoDao;
import com.co.modelos.TipoDocumento;

import co.com.interfaces.ITipoDocumentoBusiness;

@Service("business")
public class TipoDocumentoBusiness implements ITipoDocumentoBusiness {
	
	@Autowired
	private ITipoDocumentoDao dao;

	public void setDao(ITipoDocumentoDao dao) {
		this.dao = dao;
	}
	
	public ITipoDocumentoDao getDao(){
		return this.dao;
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
			if (dao != null) {
				return dao.list();
			} else {
				System.out.println("---------------------NUUUULLLL Business-----------------");	
				return null;
			}
			
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
