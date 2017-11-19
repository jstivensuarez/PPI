package com.co.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======
import org.zkoss.zk.ui.select.annotation.WireVariable;

>>>>>>> e3b1ead4a442f152330f4841c098f8657bb15786
import com.co.interfaces.ITipoDocumentoDao;
import com.co.modelos.TipoDocumento;

import co.com.interfaces.ITipoDocumentoBusiness;

@Service("business")
public class TipoDocumentoBusiness implements ITipoDocumentoBusiness {
<<<<<<< HEAD
	
=======

>>>>>>> e3b1ead4a442f152330f4841c098f8657bb15786
	@Autowired
	private ITipoDocumentoDao dao;

	public void setDao(ITipoDocumentoDao dao) {
		this.dao = dao;
	}
<<<<<<< HEAD
	
	public ITipoDocumentoDao getDao(){
		return this.dao;
	}
	
	
=======

	public ITipoDocumentoDao getDao() {
		return this.dao;
	}

>>>>>>> e3b1ead4a442f152330f4841c098f8657bb15786
	public void save(TipoDocumento t) {
		try {
			dao.save(t);
		} catch (Exception e) {
			throw e;
		}

	}

	public List<TipoDocumento> list() {
<<<<<<< HEAD
		try{
			if (dao != null) {
				return dao.list();
			} else {
				System.out.println("---------------------NUUUULLLL Business-----------------");	
				return null;
			}
			
		}catch(Exception e){
=======
		try {
			return dao.list();
		} catch (Exception e) {
>>>>>>> e3b1ead4a442f152330f4841c098f8657bb15786
			throw e;
		}
	}

	@Override
	public void remove(TipoDocumento t) {
		try {
			dao.remove(t);
		} catch (Exception e) {
			throw e;
		}
	}

}
