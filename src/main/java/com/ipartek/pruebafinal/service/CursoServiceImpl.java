package com.ipartek.pruebafinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.pruebafinal.repository.CursoDAO;
import com.ipartek.pruebafinal.vo.Curso;

@Service(value = "CursoService")
public class CursoServiceImpl implements CursoService {

	@Autowired()
	private CursoDAO dao;
	
	@Override
	public List<Curso> listar() {
		return dao.getAll();
	}
	
	@Override
	public List<Curso> listar(String filter) {
		return dao.getAll(filter);
	}
	
	@Override
	public List<Curso> listarDiez() {
		return dao.getAllTen();
	}

	@Override
	public Curso buscarPorId(long id) {
		return dao.getById(id);
	}

	@Override
	public boolean crear(Curso cur) {
		return dao.insert(cur);
	}

	@Override
	public boolean modificar(Curso cur) {
		return dao.update(cur);
	}

	@Override
	public boolean eliminar(long id) {
		return dao.delete(id);
	}

}
