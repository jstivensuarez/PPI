package com.co.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.interfaces.IUsuarioDao;
import com.co.modelos.Usuario;

import co.com.interfaces.IUsuarioBusiness;

@Service("busUser")
public class UsuarioBusiness implements IUsuarioBusiness {
	
	@Autowired
	private IUsuarioDao daoUser;

	public void setDao(IUsuarioDao dao) {
		this.daoUser = dao;
	}

	public IUsuarioDao getDao() {
		return this.daoUser;
	}

	public void save(Usuario t) {
		try {
			daoUser.save(t);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Usuario> list() {
		try {
			return daoUser.list();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void remove(Usuario t) {
		try {
			daoUser.remove(t);
		} catch (Exception e) {
			throw e;
		}
	}
}
