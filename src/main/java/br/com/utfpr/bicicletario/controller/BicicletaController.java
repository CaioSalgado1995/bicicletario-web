package br.com.utfpr.bicicletario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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


	// fluxo de primeiro cadastro, 
	@RequestMapping(method=RequestMethod.POST)
	private ModelAndView inserirBicicleta(@Valid Bicicleta bicicleta) {
		ModelAndView modelAndView = new ModelAndView("inicial/home");
		
		// checar se não tem erros de validação no formulário
		// buscar dado do usuário na sessão
		
		bicicletaDAO.inserir(bicicleta);
		
		return modelAndView;
	}
	
	// no caso de existir um novo item do menu para cadastro de bicicletas
	// criar novo método ou chamar método acima passando uma flag (primeiroCadastro = true ou false ?)
	// pensar a respeito se realmente será necessário
	
}
