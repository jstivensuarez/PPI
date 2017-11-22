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
@Table(name = "MODALIDADES")
public class Modalidad {
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "SECUENCIA_MODALIDAD", sequenceName =
	"SECUENCE_MODALIDAD", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECUENCIA_MODALIDAD")
	private int id;
	private String descripcion;
	@Transient
	private boolean estado;
	
	public Modalidad(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Modalidad() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
