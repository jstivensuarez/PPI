package com.co.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.co.interfaces.IRolDao;
import com.co.modelos.Rol;

@Repository("daoRol")
public class RolDao implements IRolDao{
	
	private Session session;
	@Autowired
	private SessionFactory sessionFactory;
	
	public RolDao() {
		
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Rol r) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(r);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Rol> list(){
		try {
			session = sessionFactory.openSession();
			List<Rol> rolList = session.createQuery("from Rol").list();
			session.close();
			return rolList;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void remove(Rol r) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(r);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			throw e;
		}
	}
}
