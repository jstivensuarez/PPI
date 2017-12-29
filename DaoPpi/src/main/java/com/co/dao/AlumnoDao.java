package com.co.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.co.interfaces.IAlumnoDao;
import com.co.modelos.Alumno;

@Repository("daoAlu")
public class AlumnoDao implements IAlumnoDao{
	
	private Session session;
	@Autowired
	private SessionFactory sessionFactory;
	
	public AlumnoDao(){
		
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Alumno a) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(a);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Alumno> list(){
		try {
			session = sessionFactory.openSession();
			List<Alumno> AlumnoList = session.createQuery("from Alumno").list();
			session.close();
			return AlumnoList;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String descripcionSede(int id) {
		session = sessionFactory.openSession();
		String descripcion = (String) session.createQuery("select " + id + " from Sede").uniqueResult();
		session.close();
		return descripcion;
	}
	
	public void remove(Alumno a) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(a);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
}
