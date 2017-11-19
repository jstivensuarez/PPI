package co.com.controller;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import com.co.modelos.Sede;
import co.com.interfaces.ISedeBussines;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class SedeVM {
	private String descripcion;

	@WireVariable
	ISedeBussines busSed;

	private String mensaje;

	private ListModelList<Sede> sedes;

	// no se si es necesario o no
	public ISedeBussines getBussines() {
		return busSed;
	}

	public void setBussines(ISedeBussines bussines) {
		this.busSed = bussines;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ListModelList<Sede> getSedes() {
		sedes = generateStatusList(busSed.list());		
		return sedes;
	}

	public void setSedes(ListModelList<Sede> sedes) {
		this.sedes = sedes;
	}

	@Init
	public void init() {
		// context = new
		// ClassPathXmlApplicationContext("configuration-context.xml");
		// business = (TipoDocumentoBusiness)
		// context.getBean("tipoDocumentoBusiness");
	}

	@Command
	@NotifyChange({ "mensaje", "sedes" })
	public void eliminar(@BindingParam("sede") Sede s) {
		try {
			busSed.remove(s);
			mensaje = "Se eliminó correctamente";
			descripcion = "";
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}

	@Command
	@NotifyChange({ "mensaje", "sedes", "descripcion" })
	public void crear() {
		try {
			if (descripcion != null) {
				Sede s = new Sede(descripcion);
				busSed.save(s);
				mensaje = "La sede se creó correctamente";
				descripcion = null;
			} else {
				mensaje = "Por favor agregue una descripción";
			}
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}

	@Command
	@NotifyChange("mensaje")
	public void confirm(@BindingParam("sede") Sede s) {
		busSed.save(s);
		cambiarStatus(s);
		refreshRowTemplate(s);
		mensaje = "se editó correctamente";
	}

	@Command
	public void cambiarStatus(@BindingParam("sede") Sede s) {
		try {
			s.setEstado(!s.getEstado());
			refreshRowTemplate(s);
		} catch (Exception ex) {
			mensaje = ex.getMessage() + "\n" + ex.getCause();
		}
	}

	public void refreshRowTemplate(Sede s) {
		sedes.set(sedes.indexOf(s), s);
	}

	private static ListModelList<Sede> generateStatusList(List<Sede> sedes) {
		ListModelList<Sede> contribs = new ListModelList<Sede>();
		for (Sede s : sedes) {
			contribs.add(s);
		}
		return contribs;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
