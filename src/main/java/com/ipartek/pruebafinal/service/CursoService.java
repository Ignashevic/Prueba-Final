package com.ipartek.pruebafinal.service;

import java.util.List;

import com.ipartek.pruebafinal.vo.Curso;
/**
 * 
 * @author Curso
 *
 */
public interface CursoService {
	
	/**
	 * Metodo listar cursos
	 * @return listado de cursos
	 */
	List<Curso> listar();
	
	/**
	 * metodo listar cursos con filtro
	 * @param filter filtro
	 * @return listado cursos
	 */
	List<Curso> listar(String filter);
	
	/**
	 * metodo lista los diez ultimos cursos
	 * @return listado de los diez ultimos cursos
	 */
	List<Curso> listarDiez();
	
	/**
	 * metodo buscar por id
	 * @param id del curso
	 * @return curso que coincida
	 */
	Curso buscarPorId(long id);
	
	/**
	 * metodo crear curso
	 * @param cur curso a insertar
	 * @return true si lo inserta, false si no
	 */
	boolean crear(Curso cur);
	
	/**
	 * metodo modificar curso
	 * @param cur curso a modificar
	 * @return true si lo hace, false si no
	 */
	boolean modificar(Curso cur);
	
	/**
	 * metodo eliminar curso
	 * @param id del curso a borrar
	 * @return true si lo hace, false si no
	 */
	boolean eliminar(long id);

}
