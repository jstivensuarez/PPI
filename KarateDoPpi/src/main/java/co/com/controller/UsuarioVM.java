package co.com.controller;

import java.util.Iterator;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import com.co.modelos.Rol;
import com.co.modelos.Usuario;

import co.com.interfaces.IRolBusiness;
import co.com.interfaces.IUsuarioBusiness;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class UsuarioVM  {

	public UsuarioVM() {

	}
	
	private boolean popUpCrear;
	private boolean popUpEliminar;
	private String nombre;
	private String correo;
	private Usuario user;
	
	@WireVariable
	IUsuarioBusiness busUser;
	@WireVariable
	IRolBusiness busRol;
	
	private String mensaje;

	private ListModelList<Usuario> usuarios;
	private List<Rol> roles;
	
	// no se si es necesario o no
	public IRolBusiness getBussinesRol() {
		return busRol;
	}
	
	public IUsuarioBusiness getBussines() {
		return busUser;
	}

	public boolean getPopUpCrear() {
		return popUpCrear;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public Usuario getId() {
		return user;
	}

	public void setId(Usuario user) {
		this.user = user;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setBussines(IUsuarioBusiness bussines) {
		this.busUser = bussines;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
	public boolean getPopUpEliminar() {
		return popUpEliminar;
	}
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public ListModelList<Usuario> getUsuarios() {
		if (busUser != null) {
			usuarios = generateStatusList(busUser.list());
		} else {
			mensaje = "Null";
		}
		return usuarios;
	}
	
	@NotifyChange({"roles","mensaje"})
	public List<Rol> getRoles() {
		if (busRol != null) {
			roles = busRol.list();
			mensaje = "";
			for (Rol iterator : roles) {
				if(iterator.getDescripcion() == null){
					mensaje += "Null";
				}		
			}
		} else {
			mensaje = "Null";
		}
		return roles;
	}

	public void setUsuarios(ListModelList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Init
	public void init() {
		popUpCrear = false;
		popUpEliminar = false;
	}

	@Command
	@NotifyChange({ "mensaje", "usuarios","popUpEliminar" })
	public void eliminar() {
		try {
			busUser.remove(user);
			mensaje = "Se eliminó correctamente";
			nombre = null;
			user = null;
			popUpEliminar = false;
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}

	@Command
	@NotifyChange({ "mensaje", "usuarios", "nombre", "correo","popUpCrear" })
	public void crear() {
		try {
			if (nombre != null) {
				Usuario s = new Usuario(nombre, correo);
				busUser.save(s);
				mensaje = "La sede se creó correctamente";
				nombre = null;
				correo = null;
				popUpCrear = false;
			} else {
				mensaje = "Por favor agregue una descripción";
			}
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}

	@Command
	@NotifyChange("mensaje")
	public void confirm(@BindingParam("usuario") Usuario s) {
		busUser.save(s);
		cambiarStatus(s);
		refreshRowTemplate(s);
	}

	@Command
	public void cambiarStatus(@BindingParam("usuario") Usuario s) {
		try {
			s.setEstado(!s.getEstado());
			refreshRowTemplate(s);
		} catch (Exception ex) {
			mensaje = ex.getMessage() + "\n" + ex.getCause();
		}
	}

	@Command
	@NotifyChange({"mensaje","popUpCrear"})
	public void mostrarPopUpCrear() {
		if(popUpCrear){
			nombre = null;
			correo = null;
		}
		popUpCrear = !popUpCrear;	
	}
	
	@Command
	@NotifyChange({"popUpEliminar","user"})
	public void mostrarPopUpEliminar(@BindingParam("usuario") Usuario s) {
		user = s;
		popUpEliminar = !popUpEliminar;		
	}
	
	public void refreshRowTemplate(Usuario s) {
		usuarios.set(usuarios.indexOf(s), s);
	}

	private static ListModelList<Usuario> generateStatusList(List<Usuario> usuarios) {
		ListModelList<Usuario> contribs = new ListModelList<Usuario>();
		for (Usuario s : usuarios) {
			contribs.add(s);
		}
		return contribs;
	}

}
