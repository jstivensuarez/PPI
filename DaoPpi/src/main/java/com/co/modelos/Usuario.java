package com.co.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="USUARIOS")
public class Usuario {

	@Id
	@Column(name="id")
	@SequenceGenerator(name = "SECUENCIA_USUARIOS", sequenceName =
	"SECUENCIA_USUARIOS", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECUENCIA_USUARIOS")  
	private int id;
	private String nombre;
	private String correo;
	@Transient
	private boolean estado;
	
	public boolean getEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Usuario(String nombre,String correo) {
		this.nombre = nombre;
		this.correo = correo;
	}
	
	public Usuario(){
		
	}
	
}
