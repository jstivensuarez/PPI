package co.com.interfaces;

import java.util.List;

import com.co.modelos.Usuario;

public interface IUsuarioBusiness {

	public void save(Usuario t);

	public List<Usuario> list();

	public void remove(Usuario t);
}
