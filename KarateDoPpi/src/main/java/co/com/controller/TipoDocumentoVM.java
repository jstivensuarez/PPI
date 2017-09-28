package co.com.controller;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.BindUtils;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.co.business.TipoDocumentoBusiness;
import com.co.modelos.TipoDocumento;

public class TipoDocumentoVM {

	private String descripcion;
	private TipoDocumentoBusiness business;
	private String mensaje;
	private ListModelList<TipoDocumento> documentos;
	private ClassPathXmlApplicationContext context;

	public void setBusiness(TipoDocumentoBusiness business) {
		this.business = business;
	}

	public List<TipoDocumento> getDocumentos() {
		documentos = generateStatusList(business.list());
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
		context = new ClassPathXmlApplicationContext("configuration-context.xml");
		business = (TipoDocumentoBusiness) context.getBean("tipoDocumentoBusiness");
	}


	@Command
	@NotifyChange({"mensaje","documentos"})
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
	@NotifyChange({"mensaje","documentos","descripcion"})
	public void crear() {
		try {
			if(descripcion != null){	
				TipoDocumento t = new TipoDocumento(descripcion);
				business.save(t);
				mensaje = "Se creó correctamente";
				descripcion = null;
			}else{
				mensaje =  "Por favor agregue una descripción";
			}
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}
	
	//Editar
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
