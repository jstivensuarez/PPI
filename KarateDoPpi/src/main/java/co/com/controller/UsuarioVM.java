package co.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import com.co.modelos.Usuario;

import co.com.interfaces.IUsuarioBusiness;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class UsuarioVM {
	
	private String nombre;
	private String correo;
	
	@WireVariable
	IUsuarioBusiness busUser;

	private String mensaje;

	private ListModelList<Usuario> usuarios;

	// no se si es necesario o no
	public IUsuarioBusiness getBussines() {
		return busUser;
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

	public ListModelList<Usuario> getUsuarios() {
		if (busUser != null) {
			usuarios = generateStatusList(busUser.list());
		} else {
			mensaje = "Null";
		}
		return usuarios;
	}

	public void setUsuarios(ListModelList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Init
	public void init() {
		// context = new
		// ClassPathXmlApplicationContext("configuration-context.xml");
		// business = (TipoDocumentoBusiness)
		// context.getBean("tipoDocumentoBusiness");
	}

	@Command
	@NotifyChange({ "mensaje", "usuarios" })
	public void eliminar(@BindingParam("usuario") Usuario s) {
		try {
			busUser.remove(s);
			mensaje = "Se eliminó correctamente";
			nombre = "";
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}

	@Command
	@NotifyChange({ "mensaje", "usuarios", "nombre","correo" })
	public void crear() {
		try {
			if (nombre != null) {
				Usuario s = new Usuario(nombre,correo);
				busUser.save(s);
				mensaje = "La sede se creó correctamente";
				nombre = null;
				correo = null;
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
	public void habilitarPopPupCrear() {
		Map arg = new HashMap();
		arg.put("someName", "");
		Executions.getCurrent().createComponents("/simples/usuario/PopPupCrear.zul",null, arg);
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
