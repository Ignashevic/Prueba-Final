package com.ipartek.pruebafinal.vo;

import javax.validation.constraints.Size;
/**
 * 
 * @author Curso
 *
 */
public class Curso {
	
	private long id;
	
	private static final int MINIMO_VALID = 3;
	private static final int MAXIMO_VALID = 255;
	private static final int MAXIMO_COD_VALID = 30;
	
	@Size(message="Debe de tener entre {min} y {max}", min=MINIMO_VALID, max=MAXIMO_VALID)
	private String nombrecur;
	
	@Size(message="Debe de tener entre {min} y {max}", min=MINIMO_VALID, max=MAXIMO_COD_VALID)
	private String codigocur;
	
	/**
	 * constructor
	 */
	public Curso() {
		super();
		this.id = -1;
		this.nombrecur = "";
		this.codigocur = "";
	}
	
	/**
	 * getter del id
	 * @return id
	 */
	public long getId() {
		return this.id;
	}
	/**
	 * setter del id
	 * @param id del curso
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * getter del nombre
	 * @return nombre del curso
	 */
	public String getNombrecur() {
		return this.nombrecur;
	}
	/**
	 * setter del nombre
	 * @param nombrecur nombre del curso
	 */
	public void setNombrecur(String nombrecur) {
		this.nombrecur = nombrecur;
	}
	/**
	 * getter del codigo del curso
	 * @return codigo del curso
	 */
	public String getCodigocur() {
		return this.codigocur;
	}
	/**
	 * setter del codigo del curso
	 * @param codigocur codigo del curso
	 */
	public void setCodigocur(String codigocur) {
		this.codigocur = codigocur;
	}

	@Override()
	public String toString() {
		return "Curso [id=" + this.id + ", nombrecur=" + this.nombrecur + ", codigocur=" + this.codigocur + "]";
	}

}
