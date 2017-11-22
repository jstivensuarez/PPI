package com.co.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.co.interfaces.ISedeDao;
import com.co.modelos.Sede;

@Repository("daoSede")
public class SedeDao implements ISedeDao {

	private Session session;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
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
			List<Sede> sedeList = session.createQuery("from Sede").list();
			session.close();
			return sedeList;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
