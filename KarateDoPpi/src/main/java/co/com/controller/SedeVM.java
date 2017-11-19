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
	ISedeBussines bussines;
	
	private String mensaje;
	
	private ListModelList<Sede> sedes;
	
	//no se si es necesario o no
		public ISedeBussines getBussines() {
			return bussines;
		}

		public void setBussines(ISedeBussines bussines) {
			this.bussines = bussines;
		}

		public String getMensaje() {
			return mensaje;
		}

		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}

		public ListModelList<Sede> getSedes() {
			if (bussines != null) {
				mensaje = "Not null";
				sedes = generateStatusList(bussines.list());
			} else {
				mensaje = "Null";
			}
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
			bussines.remove(s);
			mensaje = "Se elimin� correctamente";
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
				bussines.save(s);
				mensaje = "La sede se cre� correctamente";
				descripcion = null;
			} else {
				mensaje = "Por favor agregue una descripci�n";
			}
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}
	
	@Command
	@NotifyChange("mensaje")
	public void confirm(@BindingParam("sede") Sede s) {
		bussines.save(s);
		cambiarStatus(s);
		refreshRowTemplate(s);
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
