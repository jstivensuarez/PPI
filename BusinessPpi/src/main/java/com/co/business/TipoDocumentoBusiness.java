package com.co.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.select.annotation.WireVariable;

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

	public ITipoDocumentoDao getDao() {
		return this.dao;
	}

	public void save(TipoDocumento t) {
		try {
			dao.save(t);
		} catch (Exception e) {
			throw e;
		}

	}

	public List<TipoDocumento> list() {
		try {
			return dao.list();
		} catch (Exception e) {
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
