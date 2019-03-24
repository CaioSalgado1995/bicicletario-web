package br.com.utfpr.bicicletario.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.utfpr.bicicletario.dao.AlunoDAO;
import br.com.utfpr.bicicletario.models.Aluno;
import br.com.utfpr.bicicletario.models.Pesquisa;
import br.com.utfpr.bicicletario.models.StatusRegistro;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	private static final String TITULO_PAGINA = "tituloPagina";

	private static final String LISTA_ALUNOS = "listaAlunos";

	private static final String MENSAGEM_ERRO = "mensagemErro";
	
	private static final String FORMULARIO_ALUNO = "/cadastro/form";
	
	@Autowired
	private AlunoDAO alunoDAO;
	
	/**
	 * Método que exibe formulário para cadastro de um estudante
	 * @return página para cadastro
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView exibirFormulario() {
		return new ModelAndView(FORMULARIO_ALUNO);
	}
	
	@RequestMapping(value="/lista",method=RequestMethod.GET)
	@Cacheable(value=LISTA_ALUNOS)
	public ModelAndView exibirListaAlunos() {
		ModelAndView modelAndView = configuraModelAndViewBase("/registro/consultarAluno", "Lista de alunos já cadastrados");
	
		List<Aluno> listaAlunos = alunoDAO.buscar(StatusRegistro.FECHADO.getCodigoStatus());
		
		modelAndView.addObject(MENSAGEM_ERRO, 
				"Não existe nenhum aluno cadastrado, favor cadatrar um aluno antes de registrar sua entrada");
		modelAndView.addObject(LISTA_ALUNOS, listaAlunos);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/lista/ativos",method=RequestMethod.GET)
	@Cacheable(value="listaAlunosComRegistroEntrada")
	public ModelAndView exibirListaAlunosComRegistroAtivo() {
		ModelAndView modelAndView = configuraModelAndViewBase("/registro/consultarAlunoSaida", "Lista de alunos com registro de entrada");
		
		List<Aluno> listaAlunos = alunoDAO.buscar(StatusRegistro.ATIVO.getCodigoStatus());

		modelAndView.addObject(MENSAGEM_ERRO, "Não existe nenhum aluno com registro de entrada.");
		modelAndView.addObject(LISTA_ALUNOS, listaAlunos);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/busca", method=RequestMethod.POST)
	public ModelAndView buscarAlunos(Pesquisa pesquisa) {
		ModelAndView modelAndView;
		
		if(pesquisa.getStatus() == 1) {
			modelAndView = new ModelAndView("/registro/consultarAlunoSaida");
			modelAndView.addObject(TITULO_PAGINA, "Lista de alunos com registro de entrada");
		}else {
			modelAndView = new ModelAndView("/registro/consultarAluno");
			modelAndView.addObject(TITULO_PAGINA, "Lista de alunos");
		}
		
		List<Aluno> alunos = alunoDAO.buscar(pesquisa.getNome(), pesquisa.getStatus());
		modelAndView.addObject(MENSAGEM_ERRO, "Não existe nenhum aluno com esse nome.");
		modelAndView.addObject(LISTA_ALUNOS, alunos);
			
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@CacheEvict(value=LISTA_ALUNOS ,allEntries=true)
	public ModelAndView registrarAluno(@Valid Aluno aluno, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView;
		
		if(bindingResult.hasErrors()) {
			return new ModelAndView(FORMULARIO_ALUNO);
		}
		
		if(alunoDAO.existir(aluno)) {
			modelAndView = new ModelAndView(FORMULARIO_ALUNO);
			modelAndView.addObject(MENSAGEM_ERRO, "Aluno já cadastrado");
		}else {
			alunoDAO.inserir(aluno);
			modelAndView = new ModelAndView("redirect:bicicleta");
			redirectAttributes.addFlashAttribute("registroAluno", aluno.getRegistroAluno());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/deletar", method=RequestMethod.GET)
	public ModelAndView deletar(@PathVariable String registroAluno) {
		ModelAndView modelAndView = new ModelAndView("/aluno/confirmarDadosRemocao");

		Aluno aluno = alunoDAO.buscar(registroAluno);
		modelAndView.addObject("aluno", aluno);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/deletar", method=RequestMethod.POST)
	public ModelAndView deletar(@Valid Aluno aluno,
			RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:home");

		alunoDAO.deletar(aluno);
		redirectAttributes.addFlashAttribute("mensagemSucesso", "Aluno removido com sucesso!");
		
		return modelAndView;
		
	}
	
	private ModelAndView configuraModelAndViewBase(String caminho, String tituloPagina) {
		ModelAndView modelAndView = new ModelAndView(caminho);
		modelAndView.addObject(TITULO_PAGINA, tituloPagina);
		return modelAndView;
	}
	
}

