package com.ipartek.pruebafinal.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.pruebafinal.vo.Curso;
/**
 * 
 * @author Curso
 *
 */
public interface CursoDAO {
	
	/**
	 * Datasource del dao
	 * @param ds generico
	 */
	void setDatasource(DataSource ds);
	/**
	 * Metodo listar todos
	 * @return todos los cursos
	 */
	List<Curso> getAll();
	/**
	 * 
	 * @param id del curso
	 * @return el curso con el id a buscar
	 */
	Curso getById(long id);
	
	/**
	 * Inserta el curso k le pasamos
	 * @param cur objeto curso
	 * @return true si lo hace, false si no
	 */
	boolean insert(Curso cur);
	
	/**
	 * Modifica el curso que le pasamos
	 * @param cur objeto curso
	 * @return true si lo hace, false si no
	 */
	boolean update(Curso cur);
	
	/**
	 * Borra el curso con el id que recibe
	 * @param id del curso
	 * @return true si lo hace, false si no
	 */
	boolean delete(long id);

	/**
	 * Recoge los diez ultimos en la bbdd
	 * @return diez ultimos cursos
	 */
	List<Curso> getAllTen();

	/**
	 * Devuelve los cursos que pasen el filtro que pasamos
	 * @param filter filtro
	 * @return litado de cursos que coincidan con el filtro
	 */
	List<Curso> getAll(String filter);

}
