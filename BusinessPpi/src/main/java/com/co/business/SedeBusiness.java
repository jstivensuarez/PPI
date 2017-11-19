package com.co.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.interfaces.ISedeDao;
import com.co.modelos.Sede;

import co.com.interfaces.ISedeBussines;

@Service("busSed")
public class SedeBusiness implements ISedeBussines{
	
	@Autowired
	private ISedeDao daoSede;
	
	public void setDao(ISedeDao dao) {
		this.daoSede = dao;
	}


	public ISedeDao getDao() {
		return daoSede;
	}


	public void save(Sede s) {
		try {
			daoSede.save(s);
		} catch (Exception e) {
			throw e;
		}
	}

	
	public List<Sede> list() {
		try {
			if(daoSede != null) {
				return daoSede.list();
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
			daoSede.remove(s);
		} catch (Exception e) {
			throw e;
		}
		
	}

}
