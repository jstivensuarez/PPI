package com.co.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.co.interfaces.ITipoDocumentoDao;
import com.co.modelos.TipoDocumento;
import co.com.interfaces.ITipoDocumentoBusiness;

@Service("busDoc")
public class TipoDocumentoBusiness implements ITipoDocumentoBusiness {

	@Autowired
	private ITipoDocumentoDao daoDoc;

	public void setDao(ITipoDocumentoDao dao) {
		this.daoDoc = dao;
	}

	public ITipoDocumentoDao getDao() {
		return this.daoDoc;
	}

	public void save(TipoDocumento t) {
		try {
			daoDoc.save(t);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<TipoDocumento> list() {
		try {
			return daoDoc.list();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void remove(TipoDocumento t) {
		try {
			daoDoc.remove(t);
		} catch (Exception e) {
			throw e;
		}
	}

}
