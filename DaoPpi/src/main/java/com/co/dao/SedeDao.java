package com.co.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.co.interfaces.ISedeDao;
import com.co.modelos.Sede;

@Repository("Dao")
public class SedeDao implements ISedeDao {

	private Session session;
	
	private SessionFactory sessionFactory;
	
	
	@Override
	public void save(Sede s) {
		// TODO Auto-generated method stub
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(s);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void remove(Sede s) {
		// TODO Auto-generated method stub
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(s);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			throw e;
		}		
		
	}

	@Override
	public List<Sede> list() {
		// TODO Auto-generated method stub
		try {
			if(sessionFactory == null) {
				System.out.println("------------------HOLA QUE HACE? NULL---------");
			}
			session = sessionFactory.openSession();
			List<Sede> sedeList = session.createQuery("from sede").list();
			session.close();
			return sedeList;
		} catch (Exception e) {
			throw e;
		}
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
