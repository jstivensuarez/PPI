package co.com.controller;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.bind.annotation.BindingParam;

import java.util.List;

import com.co.modelos.TipoDocumento;

import co.com.interfaces.ITipoDocumentoBusiness;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class TipoDocumentoVM {

	private String descripcion;

	@WireVariable
	ITipoDocumentoBusiness business;
	private String mensaje;
<<<<<<< HEAD
	
=======

>>>>>>> e3b1ead4a442f152330f4841c098f8657bb15786
	private ListModelList<TipoDocumento> documentos;

	public void setBusiness(ITipoDocumentoBusiness business) {
		this.business = business;
	}

	public List<TipoDocumento> getDocumentos() {
		if (business != null) {
			mensaje = "Not null";
			documentos = generateStatusList(business.list());
		} else {
			mensaje = "Null";
		}
		return documentos;
	}

	public void setDocumentos(ListModelList<TipoDocumento> documentos) {
		this.documentos = documentos;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Init
	public void init() {
		// context = new
		// ClassPathXmlApplicationContext("configuration-context.xml");
		// business = (TipoDocumentoBusiness)
		// context.getBean("tipoDocumentoBusiness");
	}

	@Command
	@NotifyChange({ "mensaje", "documentos" })
	public void eliminar(@BindingParam("documento") TipoDocumento t) {
		try {
			business.remove(t);
			mensaje = "Se eliminó correctamente";
			descripcion = "";
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}

	@Command
	@NotifyChange({ "mensaje", "documentos", "descripcion" })
	public void crear() {
		try {
			if (descripcion != null) {
				TipoDocumento t = new TipoDocumento(descripcion);
				business.save(t);
				mensaje = "Se creó correctamente";
				descripcion = null;
			} else {
				mensaje = "Por favor agregue una descripción";
			}
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}

	// Editar
	@Command
	@NotifyChange("mensaje")
	public void confirm(@BindingParam("documento") TipoDocumento t) {
		business.save(t);
		cambiarStatus(t);
		refreshRowTemplate(t);
	}

	@Command
	public void cambiarStatus(@BindingParam("documento") TipoDocumento t) {
		try {
			t.setEstado(!t.getEstado());
			refreshRowTemplate(t);
		} catch (Exception ex) {
			mensaje = ex.getMessage() + "\n" + ex.getCause();
		}
	}

	public void refreshRowTemplate(TipoDocumento t) {
		documentos.set(documentos.indexOf(t), t);
	}

	private static ListModelList<TipoDocumento> generateStatusList(List<TipoDocumento> documentos) {
		ListModelList<TipoDocumento> contribs = new ListModelList<TipoDocumento>();
		for (TipoDocumento t : documentos) {
			contribs.add(t);
		}
		return contribs;
	}

}
