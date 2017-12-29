package com.co.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ALUMNOS")
public class Alumno {
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "SECUENCIA_ALUMNO", sequenceName =
	"SECUENCE_ALUMNO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECUENCIA_ALUMNO")
	private int id;
	private String documento;
	private String nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String correo;
	private String telefono;
	private String direccion;
	private int cinturon_id;
	private int tipo_documentos_id;
	private Date fecha_nacimiento;
	private int sede_id;
	
	@Transient
	private String sede;
	@Transient
	private String tipo_documento;
	@Transient
	private boolean estado;

	public Alumno(String documento, String nombre, String primer_apellido,
			String segundo_apellido, String correo, String telefono, String direccion,
			int cinturon_id, int tipo_documento_id, Date fecha_nacimiento, int sede_id) {
		this.documento = documento;
		this.nombre = nombre;
		this.primer_apellido = primer_apellido;
		this.segundo_apellido = segundo_apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.cinturon_id = cinturon_id;
		this.tipo_documentos_id = tipo_documento_id;
		this.fecha_nacimiento = fecha_nacimiento;
		this.sede_id = sede_id;			
	}
	
	public Alumno(Alumno a) {
		this.documento = a.documento;
		this.nombre = a.nombre;
		this.primer_apellido = a.primer_apellido;
		this.segundo_apellido = a.segundo_apellido;
		this.correo = a.correo;
		this.telefono = a.telefono;
		this.direccion = a.direccion;
		this.cinturon_id = a.cinturon_id;
		this.tipo_documentos_id = a.tipo_documentos_id;
		this.fecha_nacimiento = a.fecha_nacimiento;
		this.sede_id = a.sede_id;	
	}
	
	public Alumno(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getSede_id() {
		return sede_id;
	}

	public void setSede_id(int sede_id) {
		this.sede_id = sede_id;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	
	
}
