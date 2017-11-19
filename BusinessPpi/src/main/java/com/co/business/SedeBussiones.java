package com.co.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.interfaces.ISedeDao;
import com.co.modelos.Sede;

import co.com.interfaces.ISedeBussines;

@Service("business")
public class SedeBussiones implements ISedeBussines{
	
	@Autowired
	private ISedeDao dao;
	
	public void setDao(ISedeDao dao) {
		this.dao = dao;
	}


	public ISedeDao getDao() {
		return dao;
	}


	public void save(Sede s) {
		try {
			dao.save(s);
		} catch (Exception e) {
			throw e;
		}
	}

	
	public List<Sede> list() {
		try {
			if(dao != null) {
				return dao.list();
			}else {
				System.out.println("-----Hola que hace NULL bussines ------");
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	
	public void remove(Sede s) {
		try {
			dao.remove(s);
		} catch (Exception e) {
			throw e;
		}
		
	}

}
