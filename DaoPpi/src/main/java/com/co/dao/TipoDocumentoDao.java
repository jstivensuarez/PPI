package com.co.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.co.interfaces.ITipoDocumentoDao;
import com.co.modelos.TipoDocumento;

public class TipoDocumentoDao implements ITipoDocumentoDao {

	private Session sesion;
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(TipoDocumento t) {

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

	public List<TipoDocumento> list() {
		try {
			sesion = sessionFactory.openSession();
			List<TipoDocumento> personList = sesion.createQuery("from TipoDocumento").list();
			sesion.close();
			return personList;
		} catch (Exception e) {
			throw e;
		}
	}

	public TipoDocumentoDao() {

	}

	@Override
	public void remove(TipoDocumento t) {
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
