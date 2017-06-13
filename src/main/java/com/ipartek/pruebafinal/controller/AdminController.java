package com.ipartek.pruebafinal.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
import com.opencsv.CSVReader;
/**
 * 
 * @author Curso
 *
 */
@Controller()
public class AdminController {
	
	@Autowired()
	private CursoService servicecurso;
	
	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
	
	private static final int MIN_ARCHIVO = 8;
	
	/**
	 * Metodo para la pagina principal de la zona de admin
	 * @param model modelo
	 * @return a la vista
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String listar(Model model) {
		LOG.info("Entrando en admin");
		
		model.addAttribute("cursos", this.servicecurso.listar());
		
		return "admin/index";
		
	}
	
	/**
	 * 
	 * @param model modelo
	 * @return a la vista formcrear.jsp
	 */
	@RequestMapping(value = "/admin/curso/edit", method = RequestMethod.GET)
	public String formularioCrear(Model model) {
		LOG.info("Entrando en admin");

		model.addAttribute("curso", new Curso());
		return "admin/formcrear";
	}
	
	/**
	 * 
	 * @param model modelo
	 * @return a la vista index
	 * @throws IOException si el archivo da error al subir lanza excepcion
	 */
	@RequestMapping(value = "/admin/curso/subir", method = RequestMethod.GET)
	public String subirArchivoCSV(Model model) throws IOException {
		LOG.info("Entrando en admin");
		String [] nextLine;
		Curso cur = new Curso();
		CSVReader reader = new CSVReader(new FileReader("C:/Desarrollo/workspace3/PruebaFinal/src/main/webapp/resources/data/cursos.csv"), ';');
		while ((nextLine = reader.readNext()) != null) {
	        System.out.println(nextLine[1] + " - " + nextLine[MIN_ARCHIVO]);
	        cur.setNombrecur(nextLine[1]);
	        cur.setCodigocur(nextLine[MIN_ARCHIVO]);
	        if(!"".equals(cur.getNombrecur()) && !"".equals(cur.getCodigocur())){
	        	this.servicecurso.crear(cur);
	        }
	    }
	
		String msg = "Archivo subido correctamente";
		
		model.addAttribute("msg", msg);
		model.addAttribute("cursos", this.servicecurso.listar());
		
		return "admin/index";
		
	}

	/**
	 * 
	 * @param model modelo
	 * @param id del curso
	 * @return a la pagina formcrear.jsp
	 */
	@RequestMapping(value = "/admin/curso/edit/{id}", method = RequestMethod.GET)
	public String formularioEditar(Model model, @PathVariable() int id) {
		LOG.info("Entrando en admin");

		model.addAttribute("curso", this.servicecurso.buscarPorId(id));
		return "admin/formcrear";
	}
	
	/**
	 * 
	 * @param model modelo
	 * @param id del curso
	 * @return a la vista del detalle del curso para el usuario
	 */
	@RequestMapping(value = "/curso/show/{id}", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable() int id) {
		LOG.info("Entrando en admin");

		model.addAttribute("curso", this.servicecurso.buscarPorId(id));
		return "detalle";
	}

	/**
	 * 
	 * @param model modelo
	 * @param cur validacion del objeto
	 * @param bindingResult para validar
	 * @return a la vista del formulario crear
	 */
	@RequestMapping(value = "curso/crear", method = RequestMethod.POST)
	public String crear(Model model, @Valid() Curso cur, BindingResult bindingResult) {
		
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
	
	/**
	 * 
	 * @param model modelo
	 * @param id del curso
	 * @return a la vista index.jsp al eliminar el curso
	 */
	@RequestMapping(value = "curso/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(Model model, @PathVariable() int id) {
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
	
	/**
	 * 
	 * @param model modelo
	 * @return a la pagina migrar para migrar el archivo csv
	 */
	@RequestMapping(value = "/admin/curso/migrar", method = RequestMethod.GET)
	public String subirarchivo(Model model) {
		LOG.info("Entrando en admin");
		
		

		return "migrar";
	}

}
