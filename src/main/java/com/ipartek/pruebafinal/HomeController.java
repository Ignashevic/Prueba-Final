package com.ipartek.pruebafinal;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.pruebafinal.service.CursoService;

/**
 * 
 * @author Curso
 *
 */
@Controller()
public class HomeController {
	
	@Autowired()
	private CursoService servicecurso;
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * metodo basico que se crea automaticamente
	 * @param locale idioma
	 * @param model modelo
	 * @return a la pagina deseada
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		LOG.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("cursos", this.servicecurso.listarDiez());
		
		return "home";
	}
	

	
}
