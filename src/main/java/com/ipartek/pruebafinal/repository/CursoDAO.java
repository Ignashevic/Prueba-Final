package com.ipartek.pruebafinal.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.pruebafinal.vo.Curso;

public interface CursoDAO {
	
	/**
	 * Datasource del dao
	 * @param ds generico
	 */
	void setDatasource(DataSource ds);
	
	List<Curso> getAll();
	
	Curso getById(long id);
	
	boolean insert(Curso cur);
	
	boolean update(Curso cur);
	
	boolean delete(long id);

	List<Curso> getAllTen();

}
