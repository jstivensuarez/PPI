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
@Table(name="TIPO_DOCUMENTOS")
public class TipoDocumento {
	
	@Id
	@Column(name="id")
	@SequenceGenerator(name = "SECUENCIA_TIPO_DOC", sequenceName =
	"SECUENCIA_TIPO_DOC", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECUENCIA_TIPO_DOC")  
	private int id;
	private String descripcion;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoDocumento(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public TipoDocumento(){
		
	}
	
}
