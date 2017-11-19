package co.com.controller;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import com.co.dao.RolDao;
import com.co.modelos.Rol;

import co.com.interfaces.IRolBusiness;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class RolVM {
	
	private String descripcion;	
	@WireVariable
	IRolBusiness busRol;
	private String mensaje;
	private ListModelList<Rol> roles;
	
	public void setBusiness(IRolBusiness business) {
		this.busRol = business;
	}
	
	@Init
	public void init() {
		// context = new
		// ClassPathXmlApplicationContext("configuration-context.xml");
		// business = (TipoDocumentoBusiness)
		// context.getBean("tipoDocumentoBusiness");
	}
	
	@Command
	@NotifyChange({"mensaje", "roles"})	
	public void eliminar(@BindingParam("rol") Rol r) {
		try {
			busRol.remove(r);
			mensaje = "Se eliminó correctamente";
			descripcion = "";
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}
	
	@Command
	@NotifyChange({"mensaje", "roles", "descripcion"})
	public void crear() {
		try {
			if(descripcion != null) {
				Rol r = new Rol(descripcion);
				busRol.save(r);
				mensaje = "El Rol se creó correctamente";
				descripcion = null;				
			}else {
				mensaje = "Agregue una descripción";
			}
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}
	
	@Command 
	@NotifyChange("mensaje")
	public void confirm(@BindingParam("rol") Rol r) {
		busRol.save(r);
		cambiarStatus(r);
		refreshRowTemplate(r);
		mensaje = "se editó correctamente";
	}
	
	@Command
	public void cambiarStatus(@BindingParam("rol") Rol r) {
		try {
			r.setEstado(!r.isEstado());
			refreshRowTemplate(r);			
		} catch (Exception ex) {
			mensaje = ex.getMessage() + "\n" + ex.getCause();
		}
	}
	
	public void refreshRowTemplate(Rol r) {
		roles.set(roles.indexOf(r), r);
	}
	
	public static ListModelList<Rol> generateStatusList(List<Rol> roles){
		ListModelList<Rol> contribs = new ListModelList<Rol>();
		for(Rol r : roles) {
			contribs.add(r);
		}
		return contribs;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public ListModelList<Rol> getRoles() {
		roles = generateStatusList(busRol.list());
		return roles;
	}
	public void setRoles(ListModelList<Rol> roles) {			
		this.roles = roles;
	}
	public void setBusRol(IRolBusiness busRol) {
		this.busRol = busRol;
	}		
}
