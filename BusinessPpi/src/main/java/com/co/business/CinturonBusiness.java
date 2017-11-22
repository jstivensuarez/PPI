package com.co.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.interfaces.ICinturonDao;
import com.co.modelos.Cinturon;
import com.co.modelos.Rol;

import co.com.interfaces.ICinturonBusiness;

@Service("busCin")
public class CinturonBusiness implements ICinturonBusiness{

	@Autowired
	private ICinturonDao daoCin;
	
	public void save(Cinturon c) {
		try {
			daoCin.save(c);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Cinturon> list(){
		try {
			return daoCin.list();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void remove(Cinturon c) {
		try {
			daoCin.remove(c);
		} catch (Exception e) {
			throw e;
		}
	}

	public ICinturonDao getDaoCin() {
		return daoCin;
	}

	public void setDaoCin(ICinturonDao daoCin) {
		this.daoCin = daoCin;
	}
	
	
}
