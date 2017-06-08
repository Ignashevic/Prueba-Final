package com.ipartek.pruebafinal.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.pruebafinal.service.CursoService;
import com.ipartek.pruebafinal.vo.Curso;

@Controller
public class AdminController {
	
	@Autowired
	private CursoService servicecurso;
	
	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String listar(Model model) {
		LOG.info("Entrando en admin");
		
		model.addAttribute("cursos", this.servicecurso.listar());
		
		return "admin/index";
		
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listarDiez(Model model) {
		LOG.info("Entrando en admin");
		
		model.addAttribute("cursos", this.servicecurso.listarDiez());
		
		return "admin/index";
		
	}
	
	@RequestMapping(value = "/admin/curso/edit", method = RequestMethod.GET)
	public String formularioCrear(Model model) {
		LOG.info("Entrando en admin");

		model.addAttribute("curso", new Curso());
		return "admin/formcrear";
	}

	/**
	 * Abre el formulario con un usuario para modificarlo/eliminarlo
	 * 
	 * @param model formulario
	 * @param id de usuario
	 * @return al form.jsp
	 */
	@RequestMapping(value = "/admin/curso/edit/{id}", method = RequestMethod.GET)
	public String formularioEditar(Model model, @PathVariable() int id) {
		LOG.info("Entrando en admin");

		model.addAttribute("curso", this.servicecurso.buscarPorId(id));
		return "admin/formcrear";
	}

	/**
	 * Llama al servicio para crear o modificar el usuario
	 * 
	 * @param model del formulario
	 * @param u de usuario
	 * @return index.jsp
	 */
	@RequestMapping(value = "curso/crear", method = RequestMethod.POST)
	public String crear(Model model, @Valid Curso cur, BindingResult bindingResult) {
		
		LOG.info("Entrando en admin");
		String msg = "Error al modificar/crear un curso";
		
		if (bindingResult.hasErrors()) {
			return "admin/formcrear";
		}
		
		if (cur.getId() == -1) {
			this.servicecurso.crear(cur);
			msg = "Curso creado con exito";
		} else {
			this.servicecurso.modificar(cur);
			msg = "Curso modificado con exito";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("cursos", this.servicecurso.listar());
		
		return "admin/index";
	}
	
	@RequestMapping(value = "curso/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(Model model, @PathVariable int id) {
		LOG.info("Entrando en admin");
		String msg = "Error al eliminar el curso";
		if (this.servicecurso.eliminar(id)) {
			msg = "Curso eliminado correctamente";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("curso", new Curso());
		model.addAttribute("cursos", this.servicecurso.listar());
		return "admin/index";
	}

}
