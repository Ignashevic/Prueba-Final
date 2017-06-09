package com.ipartek.pruebafinal.api;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.pruebafinal.service.CursoService;
import com.ipartek.pruebafinal.vo.Curso;

@Controller
@RequestMapping(value = "/api/cursos/")
public class CursosApi {
	
	private static final Logger LOG = LoggerFactory.getLogger(CursosApi.class);
	
	@Autowired
	CursoService servicecurso;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Curso> listar(@RequestParam(value = "filter", required = false) String filter) {

		ArrayList<Curso> cursos = null;

		if (filter != null) {

			cursos = (ArrayList<Curso>) this.servicecurso.listar(filter);

		} else {

			// TODO Fallo seguridad mostrar informacion del usuario privada
			cursos = (ArrayList<Curso>) this.servicecurso.listar();

		}

		return cursos;
	}
}
