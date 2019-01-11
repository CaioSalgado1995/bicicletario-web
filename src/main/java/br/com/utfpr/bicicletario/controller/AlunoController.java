package br.com.utfpr.bicicletario.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.utfpr.bicicletario.dao.AlunoDAO;
import br.com.utfpr.bicicletario.dao.RegistroDAO;
import br.com.utfpr.bicicletario.models.Aluno;
import br.com.utfpr.bicicletario.models.Registro;
import br.com.utfpr.bicicletario.models.StatusRegistro;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoDAO alunoDAO;
	
	@Autowired
	private RegistroDAO registroEntradaDAO;
	
	private static final String MENSAGEM_ERRO = "mensagemErro";
	private static final String FORMULARIO_ALUNO = "/cadastro/form";

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView exibirFormulario() {
		return new ModelAndView(FORMULARIO_ALUNO);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView registrarAluno(@Valid Aluno aluno, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView;
		
		if(bindingResult.hasErrors()) {
			return new ModelAndView(FORMULARIO_ALUNO);
		}
		
		if(alunoDAO.existe(aluno)) {
			modelAndView = new ModelAndView(FORMULARIO_ALUNO);
			modelAndView.addObject(MENSAGEM_ERRO, "Aluno já cadastrado");
		}else {
			alunoDAO.inserir(aluno);
			modelAndView = new ModelAndView("redirect:bicicleta");
			redirectAttributes.addFlashAttribute("registroAluno", aluno.getRegistro());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/lista",method=RequestMethod.GET)
	public ModelAndView exibirListaAlunos() {
		ModelAndView modelAndView = new ModelAndView("/registro/consultarAluno");
		modelAndView.addObject("tituloPagina", "Lista de alunos já cadastrados");
		modelAndView.addObject("registrarEntrada", true);
		modelAndView.addObject("registrarSaida", false);
		
		List<Aluno> listaAlunos = alunoDAO.listar();
		
		if(listaAlunos.isEmpty()) {
			modelAndView.addObject("listaVazia", true);
			modelAndView.addObject(MENSAGEM_ERRO, 
					"Não existe nenhum aluno cadastrado, favor cadatrar um aluno antes de registrar sua entrada");
		}else {
			modelAndView.addObject("listaAlunos", listaAlunos);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/lista/ativos",method=RequestMethod.GET)
	public ModelAndView exibirListaAlunosComRegistroAtivo() {
		ModelAndView modelAndView = new ModelAndView("/registro/consultarAluno");
		modelAndView.addObject("tituloPagina", "Lista de alunos com registro de entrada");
		modelAndView.addObject("registrarEntrada", false);
		modelAndView.addObject("registrarSaida", true);
		
		List<Registro> listaRegistro = registroEntradaDAO.listaRegistroPorStatus(StatusRegistro.ATIVO.getCodigoStatus());
		
		if(listaRegistro.isEmpty()) {
			modelAndView.addObject("listaVazia", true);
			modelAndView.addObject(MENSAGEM_ERRO, "Não existe nenhum aluno com registro de entrada.");
		}else {
			List<String> registrosAlunos = new Registro().converteListaRegistro(listaRegistro);
			List<Aluno> listaAlunos = alunoDAO.listarAlunosComRegistroEntrada(registrosAlunos);
			modelAndView.addObject("listaAlunos", listaAlunos);
		}
		
		return modelAndView;
	}
	
}

