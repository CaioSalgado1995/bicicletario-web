package br.com.utfpr.bicicletario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.utfpr.bicicletario.models.RegistroEntrada;

@Controller
@RequestMapping("/registro")
public class RegistroController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView exibirFormulario() {
		return new ModelAndView("/registro/entrada");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView inserirRegistro() {
		ModelAndView modelAndView = new ModelAndView("home/index");
		return modelAndView;
	}
	
}
