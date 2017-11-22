package co.com.controller;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import com.co.modelos.Relacion;

import co.com.interfaces.IRelacionBusiness;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class RelacionVM {

	private String descripcion;
	@WireVariable
	IRelacionBusiness busRel;
	private String mensaje;
	private ListModelList<Relacion> relaciones;
	
	public void setBusiness(IRelacionBusiness business) {
		this.busRel = business;			
	}
	
	@Init
	public void init() {
		// context = new
		// ClassPathXmlApplicationContext("configuration-context.xml");
		// business = (TipoDocumentoBusiness)
		// context.getBean("tipoDocumentoBusiness");
	}
	
	@Command
	@NotifyChange({"mensaje", "relaciones"})	
	public void eliminar(@BindingParam("relacion") Relacion r) {
		try {
			busRel.remove(r);;
			mensaje = "Se eliminó correctamente";
			descripcion = "";
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}
	
	@Command
	@NotifyChange({"mensaje", "relaciones", "descripcion"})
	public void crear() {
		try {
			if(descripcion != null) {
				Relacion r = new Relacion(descripcion);
				busRel.save(r);;
				mensaje = "La relacion se creó correctamente";
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
	public void confirm(@BindingParam("relacion") Relacion r) {
		busRel.save(r);
		cambiarStatus(r);
		refreshRowTemplate(r);
		mensaje = "se editó correctamente";
	}
	
	@Command
	public void cambiarStatus(@BindingParam("relacion") Relacion r) {
		try {
			r.setEstado(!r.isEstado());
			refreshRowTemplate(r);			
		} catch (Exception ex) {
			mensaje = ex.getMessage() + "\n" + ex.getCause();
		}
	}
	
	public void refreshRowTemplate(Relacion r) {
		relaciones.set(relaciones.indexOf(r), r);
	}
	
	public static ListModelList<Relacion> generateStatusList(List<Relacion> relaciones){
		ListModelList<Relacion> contribs = new ListModelList<Relacion>();
		for(Relacion r : relaciones) {
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

	public ListModelList<Relacion> getRelaciones() {
		relaciones = generateStatusList(busRel.list());
		return relaciones;
	}

	public void setRelaciones(ListModelList<Relacion> relaciones) {
		this.relaciones = relaciones;
	}

	public void setBusRel(IRelacionBusiness busRel) {
		this.busRel = busRel;
	}
	
	
}
