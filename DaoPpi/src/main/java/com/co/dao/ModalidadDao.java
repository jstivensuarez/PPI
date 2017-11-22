package com.co.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.co.interfaces.IModalidadDao;
import com.co.modelos.Modalidad;

@Repository("daoMod")
public class ModalidadDao implements IModalidadDao{
	
	private Session session;
	@Autowired
	private SessionFactory sessionFactory;
	
	public ModalidadDao() {
		
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Modalidad m) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(m);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Modalidad> list(){
		try {
			session = sessionFactory.openSession();
			List<Modalidad> modalidadList = session.createQuery("from Modalidad").list();
			session.close();
			return modalidadList;
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void remove(Modalidad m) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(m);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			throw e;
		}
	}
}
