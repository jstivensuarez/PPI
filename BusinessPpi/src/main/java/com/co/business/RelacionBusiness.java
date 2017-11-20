package com.co.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.interfaces.IRelacionDao;
import com.co.modelos.Relacion;

import co.com.interfaces.IRelacionBusiness;

@Service("busRel")
public class RelacionBusiness implements IRelacionBusiness{
	
	@Autowired
	private IRelacionDao daoRel;
	
	public void save(Relacion r) {
		try {
			daoRel.save(r);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Relacion> list(){
		try {
			return daoRel.list();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void remove(Relacion r) {
		try {
			daoRel.remove(r);
		} catch (Exception e) {
			throw e;
		}
	}

	public IRelacionDao getDaoRel() {
		return daoRel;
	}

	public void setDaoRel(IRelacionDao daoRel) {
		this.daoRel = daoRel;
	}
	
	
}
