package com.co.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.co.interfaces.IUsuarioDao;
import com.co.modelos.Usuario;

@Repository("daoUser")
public class UsuarioDao implements IUsuarioDao  {

	private Session sesion;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Usuario t) {

		try {
			
			sesion = sessionFactory.openSession();
			sesion.beginTransaction();
			sesion.saveOrUpdate(t);
			sesion.getTransaction().commit();
			sesion.close();
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Usuario> list() {
		try {
			sesion = sessionFactory.openSession();
			List<Usuario> usuarios = sesion.createQuery("from Usuario").list();
			sesion.close();
			return usuarios;
		} catch (Exception e) {
			throw e;
		}
	}

	public UsuarioDao() {

	}

	@Override
	public void remove(Usuario t) {
		try {
			sesion = sessionFactory.openSession();
			sesion.beginTransaction();
			sesion.delete(t);
			sesion.getTransaction().commit();
			sesion.close();
		} catch (Exception e) {
			throw e;
		}
	}
}
