package com.co.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.co.interfaces.IRelacionDao;
import com.co.modelos.Relacion;

@Repository("daoRel")
public class RelacionDao implements IRelacionDao{

	private Session session;
	@Autowired
	private SessionFactory sessionFactory;
	
	public RelacionDao() {
		
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Relacion r) {
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
	
	public List<Relacion> list(){
		try {
			session = sessionFactory.openSession();
			List<Relacion> relacionList = session.createQuery("from Relacion").list();
			session.close();
			return relacionList;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void remove(Relacion r) {
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
