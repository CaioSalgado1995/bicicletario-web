package br.com.utfpr.bicicletario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// fluxo de primeiro cadastro, 
	@RequestMapping(value="/{registroAluno}",method=RequestMethod.POST)
	private ModelAndView inserirBicicleta(@PathVariable("registroAluno") String registroAluno, Bicicleta bicicleta) {
		ModelAndView modelAndView = new ModelAndView("registro/entrada");
		
		bicicleta.setRegistroAluno(registroAluno);
		// checar se não tem erros de validação no formulário
		// buscar dado do usuário na sessão
		bicicletaDAO.inserir(bicicleta);
		modelAndView.addObject("registroAluno", registroAluno);
		
		
		return modelAndView;
	}
	
	// no caso de existir um novo item do menu para cadastro de bicicletas
	// criar novo método ou chamar método acima passando uma flag (primeiroCadastro = true ou false ?)
	// pensar a respeito se realmente será necessário
	
}
