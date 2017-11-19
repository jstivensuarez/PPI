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
@Table(name="SEDE")
public class Sede {
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "SECUENCIA_SEDE", sequenceName =
			"SECUENCIA_SEDE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECUENCIA_SEDE") 
	private int id;
	private String nombre;
	
	@Transient
	private boolean estado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String descripcion) {
		this.nombre = descripcion;
	}
		
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Sede(String descripcion) {
		this.nombre = descripcion;
	}
	
	public Sede() {
		
	}
	
}
