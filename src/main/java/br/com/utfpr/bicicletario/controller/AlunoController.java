package br.com.utfpr.bicicletario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value="/lista",method=RequestMethod.GET)
	public ModelAndView exibirListaAlunos() {
		ModelAndView modelAndView = new ModelAndView("/registro/consultarAluno");
		
		List<Aluno> listaAlunos = alunoDAO.listar();
		
		if(listaAlunos.isEmpty()) {
			modelAndView.addObject("listaVazia", true);
			modelAndView.addObject("mensagemErro", 
					"Não existe nenhum aluno cadastrado, favor cadatrar um aluno antes de registrar sua entrada");
		}else {
			modelAndView.addObject("listaAlunos", listaAlunos);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView registrarAluno(Aluno aluno, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView;
		
		// TODO checar erros de validação do formulário, 
		// utilizar a especificação de validação do hibernate
		// se o aluno já existe gera mensagem de erro na tela
		
		if(alunoDAO.existe(aluno)) {
			modelAndView = new ModelAndView("/cadastro/form");
			modelAndView.addObject("mensagemErro", "Aluno já cadastrado");
		}else {
			alunoDAO.inserir(aluno);
			modelAndView = new ModelAndView("redirect:bicicleta");
			redirectAttributes.addFlashAttribute("registroAluno", aluno.getRegistro());
		}
		
		return modelAndView;
	}
	
}

