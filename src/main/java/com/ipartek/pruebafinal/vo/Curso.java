package com.ipartek.pruebafinal.vo;

public class Curso {
	
	private long id;
	private String nombrecur;
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
