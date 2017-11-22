package com.co.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.interfaces.IModalidadDao;
import com.co.modelos.Modalidad;

import co.com.interfaces.IModalidadBusiness;

@Service("busMod")
public class ModalidadBusiness implements IModalidadBusiness {

	@Autowired
	private IModalidadDao daoMod;
	
	public void save(Modalidad m) {
		try {
			daoMod.save(m);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Modalidad> list(){
		try {
			return daoMod.list();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void remove(Modalidad m){
		try {
			daoMod.remove(m);
		} catch (Exception e) {
			throw e;
		}
	}

	public IModalidadDao getDaoMod() {
		return daoMod;
	}

	public void setDaoMod(IModalidadDao daoMod) {
		this.daoMod = daoMod;
	}
	
}
