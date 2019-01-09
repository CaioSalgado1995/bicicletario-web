package br.com.utfpr.bicicletario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.utfpr.bicicletario.models.RegistroEntrada;

@Controller
@RequestMapping("/registro")
public class RegistroController {

	
	@RequestMapping(value="/{registroAluno}", method=RequestMethod.GET)
	public ModelAndView registroEntradaAlunoJaCadastrado(@PathVariable String registroAluno) {
		ModelAndView modelAndView = new ModelAndView("/registro/entrada");
		modelAndView.addObject("registroAluno", registroAluno);
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView inserirRegistro(RegistroEntrada registroEntrada) {
		ModelAndView modelAndView = new ModelAndView("home/index");
		return modelAndView;
	}
	
}
