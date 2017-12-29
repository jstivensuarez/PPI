package co.com.controller;

import java.util.Date;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import com.co.modelos.Alumno;
import com.co.modelos.Sede;

import co.com.interfaces.IAlumnoBusiness;
import co.com.interfaces.ISedeBussines;


@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class AlumnoVM {
	
	@WireVariable
	IAlumnoBusiness busAlu;
	
	@WireVariable 
	ISedeBussines busSed; 
	
	private String mensaje;
	private ListModelList<Alumno> alumnos;
	private ListModelList<Sede> sedes;
	private String documento;
	private String nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String correo;
	private String telefono;
	private String direccion;
	private int cinturon_id;
	private Alumno alumno;
	private int tipo_documentos_id;
	private Date fecha_nacimiento;
	
	
	@Init
	public void init() {
		
	}
	
	@Command
	@NotifyChange({"mensaje", "alumno"})
	public void crear() {
		try {
			if(alumnos != null) {
				Alumno a = new Alumno(alumno);
				busAlu.save(a);
				mensaje = "El Alumno se creó correctamente";
								
			}else {
				mensaje = "Agregue una descripción";
			}
		} catch (Exception ex) {
			mensaje = "Error inesperado: " + ex.getMessage() + " " + ex.getCause();
		}
	}
	
	@Command
	public String recuperarSede(@BindingParam("sede") int sede) {
		
		return "a";
	}
	
	
	
	public void refreshRowTemplate(Alumno a) {
		alumnos.set(alumnos.indexOf(a), a);
	}
	
	public static ListModelList<Alumno> generateStatusList(List<Alumno> alumnos){
		ListModelList<Alumno> contribs = new ListModelList<Alumno>();
		for(Alumno a : alumnos) {
			contribs.add(a);
		}
		return contribs;
	}
	
	public static ListModelList<Sede> generateStatusListSede(List<Sede> sedes){
		ListModelList<Sede> contribs = new ListModelList<Sede>();
		for(Sede s : sedes) {
			contribs.add(s);
		}
		return contribs;
	}

	public IAlumnoBusiness getBusAlu() {
		return busAlu;
	}

	public void setBusAlu(IAlumnoBusiness busAlu) {
		this.busAlu = busAlu;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ListModelList<Alumno> getAlumnos() {
		int cont = 0;
		List<Alumno> alums = busAlu.list();
		List<Sede> seds = busSed.list();
		for (Alumno alumno : alums) {
			alumno.setSede("a");
			for (Sede sede : seds) {
				if(alumno.getSede_id() == sede.getId()) {
					cont = 1;
				}
				if(cont == 1) {
					alumno.setSede(sede.getNombre());
					cont = 0;
				}
			}
			
		}
		alumnos = generateStatusList(alums);
		sedes = generateStatusListSede(busSed.list());
		return alumnos;
	}

	public void setAlumnos(ListModelList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimer_apellido() {
		return primer_apellido;
	}

	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCinturon_id() {
		return cinturon_id;
	}

	public void setCinturon_id(int cinturon_id) {
		this.cinturon_id = cinturon_id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public ListModelList<Sede> getSedes() {
		return sedes;
	}

	public void setSedes(ListModelList<Sede> sedes) {
		this.sedes = sedes;
	}

	public int getTipo_documentos_id() {
		return tipo_documentos_id;
	}

	public void setTipo_documentos_id(int tipo_documentos_id) {
		this.tipo_documentos_id = tipo_documentos_id;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public ISedeBussines getBusSed() {
		return busSed;
	}

	public void setBusSed(ISedeBussines busSed) {
		this.busSed = busSed;
	}	
	
}
