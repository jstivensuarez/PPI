package com.co.interfaces;

import java.util.List;

import com.co.modelos.Cinturon;

public interface ICinturonDao {
	
	public void save(Cinturon c);
	
	public void remove(Cinturon c);
	
	public List<Cinturon> list();
}
