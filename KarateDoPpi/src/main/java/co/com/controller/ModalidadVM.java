package co.com.controller;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import com.co.modelos.Modalidad;
import com.co.modelos.Rol;

import co.com.interfaces.IModalidadBusiness;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ModalidadVM {
	
	private String descripcion;
	@WireVariable
	IModalidadBusiness busMod;
	private String mensaje;
	private ListModelList<Modalidad> modalidades;
	
	public void setBusiness(IModalidadBusiness business) {
		this.busMod = business;			
	}
	
	@Init
	public void init() {
		// context = new
		// ClassPathXmlApplicationContext("configuration-context.xml");
		// business = (TipoDocumentoBusiness)
		// context.getBean("tipoDocumentoBusiness");
	}
	
	@Command
	@NotifyChange({"mensaje", "modalidades"})	
	public void eliminar(@BindingParam("modalidad") Modalidad m) {
		try {
			busMod.remove(m);;
			mensaje = "Se eliminó correctamente";
			descripcion = "";
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}
	
	@Command
	@NotifyChange({"mensaje", "modalidades", "descripcion"})
	public void crear() {
		try {
			if(descripcion != null) {
				Modalidad m = new Modalidad(descripcion);
				busMod.save(m);;
				mensaje = "La modalidad se creó correctamente";
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
	public void confirm(@BindingParam("modalidad") Modalidad m) {
		busMod.save(m);
		cambiarStatus(m);
		refreshRowTemplate(m);
		mensaje = "se editó correctamente";
	}
	
	@Command
	public void cambiarStatus(@BindingParam("modalidad") Modalidad m) {
		try {
			m.setEstado(!m.isEstado());
			refreshRowTemplate(m);			
		} catch (Exception ex) {
			mensaje = ex.getMessage() + "\n" + ex.getCause();
		}
	}
	
	public void refreshRowTemplate(Modalidad m) {
		modalidades.set(modalidades.indexOf(m), m);
	}
	
	public static ListModelList<Modalidad> generateStatusList(List<Modalidad> modalidades){
		ListModelList<Modalidad> contribs = new ListModelList<Modalidad>();
		for(Modalidad m : modalidades) {
			contribs.add(m);
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

	public ListModelList<Modalidad> getModalidades() {
		modalidades = generateStatusList(busMod.list());
		return modalidades;
	}

	public void setModalidades(ListModelList<Modalidad> modalidades) {
		this.modalidades = modalidades;
	}

	public void setBusModalidad(IModalidadBusiness busModalidad) {
		this.busMod = busModalidad;
	}
	
	
	
}
