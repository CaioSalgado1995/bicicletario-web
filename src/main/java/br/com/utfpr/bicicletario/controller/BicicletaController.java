package br.com.utfpr.bicicletario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.utfpr.bicicletario.dao.BicicletaDAO;
import br.com.utfpr.bicicletario.models.Bicicleta;

@Controller
@RequestMapping("/bicicleta")
public class BicicletaController {

	@Autowired
	private BicicletaDAO bicicletaDAO;


	@RequestMapping(method=RequestMethod.GET)
	private ModelAndView exibirCadastroBicicleta() {
		return new ModelAndView("/cadastro/bicicletaForm");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	private ModelAndView inserirBicicleta(@Valid Bicicleta bicicleta, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:registro/" + bicicleta.getRegistroAluno());
		

		if(bindingResult.hasErrors()) {
			return new ModelAndView("/cadastro/bicicletaForm");
		}
		
		bicicletaDAO.inserir(bicicleta);
		
		return modelAndView;
	}
	
}
