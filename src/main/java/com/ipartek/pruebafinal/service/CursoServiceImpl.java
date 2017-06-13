package com.ipartek.pruebafinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.pruebafinal.repository.CursoDAO;
import com.ipartek.pruebafinal.vo.Curso;
/**
 * 
 * @author Curso
 *
 */
@Service(value = "CursoService")
public class CursoServiceImpl implements CursoService {

	@Autowired()
	private CursoDAO dao;
	
	@Override()
	public List<Curso> listar() {
		return this.dao.getAll();
	}
	
	@Override()
	public List<Curso> listar(String filter) {
		return this.dao.getAll(filter);
	}
	
	@Override()
	public List<Curso> listarDiez() {
		return this.dao.getAllTen();
	}

	@Override()
	public Curso buscarPorId(long id) {
		return this.dao.getById(id);
	}

	@Override()
	public boolean crear(Curso cur) {
		return this.dao.insert(cur);
	}

	@Override()
	public boolean modificar(Curso cur) {
		return this.dao.update(cur);
	}

	@Override()
	public boolean eliminar(long id) {
		return this.dao.delete(id);
	}

}
