package com.ipartek.pruebafinal.service;

import java.util.List;

import com.ipartek.pruebafinal.vo.Curso;

public interface CursoService {
	
	List<Curso> listar();
	
	List<Curso> listar(String filter);
	
	List<Curso> listarDiez();
	
	Curso buscarPorId(long id);
	
	boolean crear(Curso cur);
	
	boolean modificar(Curso cur);
	
	boolean eliminar(long id);

}
