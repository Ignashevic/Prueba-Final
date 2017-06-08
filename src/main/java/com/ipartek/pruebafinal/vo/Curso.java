package com.ipartek.pruebafinal.vo;

import javax.validation.constraints.Size;

public class Curso {
	
	private long id;
	
	@Size(message="Debe de tener entre {min} y {max}", min=3, max=255)
	private String nombrecur;
	
	@Size(message="Debe de tener entre {min} y {max}", min=3, max=30)
	private String codigocur;
	
	public Curso() {
		super();
		this.id = -1;
		this.nombrecur = "";
		this.codigocur = "";
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombrecur() {
		return nombrecur;
	}
	public void setNombrecur(String nombrecur) {
		this.nombrecur = nombrecur;
	}
	public String getCodigocur() {
		return codigocur;
	}
	public void setCodigocur(String codigocur) {
		this.codigocur = codigocur;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombrecur=" + nombrecur + ", codigocur=" + codigocur + "]";
	}

}
