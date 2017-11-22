package com.co.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.interfaces.IRolDao;
import com.co.modelos.Rol;

import co.com.interfaces.IRolBusiness;

@Service("busRol")
public class RolBusiness implements IRolBusiness{
	
	@Autowired
	private IRolDao daoRol;
	
	public void save(Rol r) {
		try {
			daoRol.save(r);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Rol> list(){
		try {
			return daoRol.list();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void remove(Rol r) {
		try {
			daoRol.remove(r);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public IRolDao getDaoRol() {
		return daoRol;
	}

	public void setDaoRol(IRolDao daoRol) {
		this.daoRol = daoRol;
	}
	
	
}
