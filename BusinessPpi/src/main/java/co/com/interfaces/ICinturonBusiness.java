package co.com.interfaces;

import java.util.List;

import com.co.modelos.Cinturon;

public interface ICinturonBusiness {

	public void save(Cinturon c);
	
	public List<Cinturon> list();
	
	public void remove(Cinturon c);
}
