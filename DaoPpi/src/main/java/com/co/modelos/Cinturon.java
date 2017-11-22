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
@Table(name = "CINTURONES")
public class Cinturon {
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "SECUENCIA_CINTURON", sequenceName =
	"SECUENCE_CINTURON", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECUENCIA_CINTURON")
	private int id;
	private String descripcion;
	@Transient
	private boolean estado;
	
	public Cinturon(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Cinturon() {
		
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
