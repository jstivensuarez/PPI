package com.co.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.co.interfaces.ICinturonDao;
import com.co.modelos.Cinturon;

@Repository("daoCin")
public class CinturonDao implements ICinturonDao{
	
	private Session session;
	@Autowired
	private SessionFactory sessionFactory;
	
	public CinturonDao() {
		
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Cinturon c) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(c);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Cinturon> list(){
		try {
			session = sessionFactory.openSession();
			List<Cinturon> cinturonList = session.createQuery("from Cinturon").list();
			session.close();
			return cinturonList;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void remove(Cinturon c) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(c);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
}
