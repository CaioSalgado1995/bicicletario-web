package br.com.utfpr.bicicletario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.utfpr.bicicletario.dao.RegistroDAO;
import br.com.utfpr.bicicletario.models.Registro;
import br.com.utfpr.bicicletario.models.StatusRegistro;

@Controller
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private RegistroDAO registroEntradaDAO;

	@RequestMapping(value="/{registroAluno}", method=RequestMethod.GET)
	public ModelAndView registroEntradaAlunoJaCadastrado(@PathVariable String registroAluno) {
		ModelAndView modelAndView = new ModelAndView("/registro/entrada");
		modelAndView.addObject("registroAluno", registroAluno);

		return modelAndView;
	}
	
	@RequestMapping(value="/saida/{registroAluno}", method=RequestMethod.GET)
	public ModelAndView registroSaidaAluno(@PathVariable String registroAluno) {
		ModelAndView modelAndView = new ModelAndView("/registro/saida");
		modelAndView.addObject("registroAluno", registroAluno);

		return modelAndView;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView inserirRegistro(Registro registroEntrada, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/home");
		registroEntrada.setStatus(StatusRegistro.ATIVO.getCodigoStatus());

		if(registroEntradaDAO.existeRegistroAtivo(registroEntrada)) {
			redirectAttributes.addFlashAttribute("mensagemErro", "O Aluno " + registroEntrada.getRegistroAluno() + " já tem registro de entrada");
		}else {
			registroEntradaDAO.inserir(registroEntrada);
			redirectAttributes.addFlashAttribute("mensagemSucesso", "Registro de entrada concluído para o aluno " + registroEntrada.getRegistroAluno());
		}

		return modelAndView;
	}
	
	@RequestMapping(value="/saida",method=RequestMethod.POST)
	public ModelAndView atualizarRegistroComSaida(Registro registroSaida, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/home");
		
		Registro registroAtual = registroEntradaDAO.buscaRegistro(registroSaida.getRegistroAluno(), StatusRegistro.ATIVO.getCodigoStatus());
		registroAtual.setDataSaida(registroSaida.getDataSaida());
		registroAtual.setHorarioSaida(registroSaida.getHorarioSaida());
		registroAtual.setStatus(StatusRegistro.FECHADO.getCodigoStatus());
		
		registroEntradaDAO.atualiza(registroAtual);
		redirectAttributes.addFlashAttribute("mensagemSucesso", "Registro de saída concluído para o aluno " + registroSaida.getRegistroAluno());
		return modelAndView;
	}
	
	@RequestMapping(value="/finalizados",method=RequestMethod.GET)
	public ModelAndView consultarRegistrosFechados() {
		ModelAndView modelAndView = new ModelAndView("/registro/historico");
		List<Registro> registrosFinalizados = registroEntradaDAO.listaRegistroPorStatus(StatusRegistro.FECHADO.getCodigoStatus());
	
		if(registrosFinalizados.isEmpty()) {
			modelAndView.addObject("listaVazia", true);
			modelAndView.addObject("mensagemErro", "Não existe nenhum histórico de registros.");
		}else {
			modelAndView.addObject("listaRegistros", registrosFinalizados);
		}
		
		return modelAndView;
	}

}
