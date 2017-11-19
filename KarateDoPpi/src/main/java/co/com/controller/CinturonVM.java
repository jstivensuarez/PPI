package co.com.controller;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import com.co.modelos.Cinturon;
import co.com.interfaces.ICinturonBusiness;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CinturonVM {
	
	private String descripcion;
	@WireVariable
	ICinturonBusiness busCin;
	private String mensaje;
	private ListModelList<Cinturon> cinturones;
	
	public void setBusiness(ICinturonBusiness business) {
		this.busCin = business;			
	}
	
	@Init
	public void init() {
		// context = new
		// ClassPathXmlApplicationContext("configuration-context.xml");
		// business = (TipoDocumentoBusiness)
		// context.getBean("tipoDocumentoBusiness");
	}
	
	@Command
	@NotifyChange({"mensaje", "cinturones"})	
	public void eliminar(@BindingParam("cinturon") Cinturon c) {
		try {
			busCin.remove(c);;
			mensaje = "Se eliminó correctamente";
			descripcion = "";
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}
	
	@Command
	@NotifyChange({"mensaje", "cinturones", "descripcion"})
	public void crear() {
		try {
			if(descripcion != null) {
				Cinturon c = new Cinturon(descripcion);
				busCin.save(c);;
				mensaje = "El cinturon se creó correctamente";
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
	public void confirm(@BindingParam("cinturon") Cinturon c) {
		busCin.save(c);
		cambiarStatus(c);
		refreshRowTemplate(c);
		mensaje = "se editó correctamente";
	}
	
	@Command
	public void cambiarStatus(@BindingParam("cinturon") Cinturon c) {
		try {
			c.setEstado(!c.isEstado());
			refreshRowTemplate(c);			
		} catch (Exception ex) {
			mensaje = ex.getMessage() + "\n" + ex.getCause();
		}
	}
	
	public void refreshRowTemplate(Cinturon c) {
		cinturones.set(cinturones.indexOf(c), c);
	}
	
	public static ListModelList<Cinturon> generateStatusList(List<Cinturon> cinturones){
		ListModelList<Cinturon> contribs = new ListModelList<Cinturon>();
		for(Cinturon c : cinturones) {
			contribs.add(c);
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

	public ListModelList<Cinturon> getCinturones() {
		cinturones = generateStatusList(busCin.list());
		return cinturones;
	}

	public void setCinturones(ListModelList<Cinturon> cinturones) {
		this.cinturones = cinturones;
	}

	public void setBusCin(ICinturonBusiness busCin) {
		this.busCin = busCin;
	}
	
}
