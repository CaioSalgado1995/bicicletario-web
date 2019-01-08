package br.com.utfpr.bicicletario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.utfpr.bicicletario.dao.AlunoDAO;
import br.com.utfpr.bicicletario.models.Aluno;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoDAO alunoDAO;

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView exibirFormulario() {
		return new ModelAndView("/cadastro/form");
	}
	
	// fluxo feliz, onde o primeiro cadastro do aluno � feito e logo em seguida o cadastro da sua bicicleta
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView registrarAluno(Aluno aluno) {
		ModelAndView modelAndView = new ModelAndView("/cadastro/bicicletaForm");
		modelAndView.addObject("aluno", aluno);
		
		// checar erros de valida��o do formul�rio
		
		// caso n�o tenha erros insere o aluno na base de dados
		alunoDAO.inserir(aluno);
		
		// setar o registro do usu�rio na sess�o
		// verificar como trabalhar de uma forma adequada com a sess�o
		
		return modelAndView;
	}
	
}

