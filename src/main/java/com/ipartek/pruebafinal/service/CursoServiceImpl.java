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

}
