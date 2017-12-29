package com.co.modelos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "ROLES")
public class Rol {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "SECUENCIA_ROL", sequenceName = "SECUENCE_ROL", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECUENCIA_ROL")
	private int id;
	private String descripcion;
	@Transient
	private boolean estado;

	@Autowired
	@ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "usuarios")
	private Set<Usuario> usuarios = new HashSet();

	public Rol(String descripcion) {
		this.descripcion = descripcion;
	}

	public Rol() {

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
