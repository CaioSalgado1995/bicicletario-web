package br.com.utfpr.bicicletario.controller;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.utfpr.bicicletario.dao.RegistroDAO;
import br.com.utfpr.bicicletario.models.BaseRegistro;
import br.com.utfpr.bicicletario.models.Registro;
import br.com.utfpr.bicicletario.models.StatusRegistro;

@Controller
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private RegistroDAO registroDAO;
	
	private static final String VAR_DATA_ATUAL = "dataAtual";
	private static final String VAR_REGISTRO_ALUNO = "registroAluno";

	@RequestMapping(value="/{registroAluno}", method=RequestMethod.GET)
	public ModelAndView registroEntradaAlunoJaCadastrado(@PathVariable String registroAluno) {
		ModelAndView modelAndView = new ModelAndView("/registro/entrada");
		modelAndView.addObject(VAR_DATA_ATUAL, Calendar.getInstance().getTime());
		modelAndView.addObject(VAR_REGISTRO_ALUNO, registroAluno);

		return modelAndView;
	}
	
	@RequestMapping(value="/saida/{registroAluno}", method=RequestMethod.GET)
	public ModelAndView registroSaidaAluno(@PathVariable String registroAluno) {
		ModelAndView modelAndView = new ModelAndView("/registro/saida");
		modelAndView.addObject(VAR_DATA_ATUAL, Calendar.getInstance().getTime());
		modelAndView.addObject(VAR_REGISTRO_ALUNO, registroAluno);

		return modelAndView;
	}
	
	@RequestMapping(value="/finalizados",method=RequestMethod.GET)
	public ModelAndView consultarRegistrosFechados() {
		ModelAndView modelAndView = new ModelAndView("/registro/historico");
		List<Registro> registrosFinalizados = registroDAO.listaRegistroPorStatus(StatusRegistro.FECHADO.getCodigoStatus());
	
		if(registrosFinalizados.isEmpty()) {
			modelAndView.addObject("listaVazia", true);
			modelAndView.addObject("mensagemErro", "Não existe nenhum histórico de registros.");
		}else {
			modelAndView.addObject("listaRegistros", registrosFinalizados);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/consulta/periodo/{registroAluno}", method=RequestMethod.GET)
	public ModelAndView consultarPeriodoUso(@PathVariable String registroAluno) {
		ModelAndView modelAndView = new ModelAndView("/registro/consultarPorPeriodo");
		
		Registro registroEntrada = 
				registroDAO.buscaRegistro(registroAluno, StatusRegistro.ATIVO.getCodigoStatus());
		
		Calendar dataAtual = Calendar.getInstance();
		Calendar dataEntradaAluno = registroEntrada.getDataEntrada();
		
		long diferencaTempo = Math.abs(dataEntradaAluno.getTimeInMillis() - dataAtual.getTimeInMillis());
		
		long dias = TimeUnit.MILLISECONDS.toDays(diferencaTempo);
		long horas = (TimeUnit.MILLISECONDS.toHours(diferencaTempo) % 24);
		long minutos = (TimeUnit.MILLISECONDS.toMinutes(diferencaTempo) % 60);
		
		modelAndView.addObject("dias", dias);
		modelAndView.addObject("horas", horas);
		modelAndView.addObject("minutos", minutos);
		modelAndView.addObject(VAR_REGISTRO_ALUNO, registroAluno);
		
		if(dias >= 2) {
			modelAndView.addObject("avisoTermino", true);
		}
		
		return modelAndView;
	}

	@RequestMapping(method=RequestMethod.POST)
	@CacheEvict(value="listaAlunosComRegistroEntrada", allEntries=true)
	public ModelAndView inserirRegistro(@Valid BaseRegistro registro, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView;
		
		if(bindingResult.hasErrors()) {
			modelAndView = new ModelAndView("/registro/entrada");
			modelAndView.addObject(VAR_DATA_ATUAL, Calendar.getInstance().getTime());
			modelAndView.addObject(VAR_REGISTRO_ALUNO, registro.getRegistroAluno());
			return modelAndView;
		}
	
		modelAndView = new ModelAndView("redirect:/home");
		// externalizar isso para a modelo
		Registro registroFinal = new Registro();
		registroFinal.setStatus(StatusRegistro.ATIVO.getCodigoStatus());
		registroFinal.setRegistroAluno(registro.getRegistroAluno());
		registroFinal.setDataEntrada(Calendar.getInstance());
		registroFinal.setHorarioEntrada(registro.getHorario());
		
		if(registroDAO.existeRegistroAtivo(registroFinal)) {
			redirectAttributes.addFlashAttribute("mensagemErro", "O Aluno " + registroFinal.getRegistroAluno() + " já tem registro de entrada");
		}else {
			registroDAO.inserir(registroFinal);
			redirectAttributes.addFlashAttribute("mensagemSucesso", "Registro de entrada concluído para o aluno " + registroFinal.getRegistroAluno());
		}

		return modelAndView;
	}
	
	@RequestMapping(value="/saida",method=RequestMethod.POST)
	public ModelAndView atualizarRegistroComSaida(@Valid BaseRegistro registro, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView;
		
		if(bindingResult.hasErrors()) {
			modelAndView = new ModelAndView("/registro/saida");
			modelAndView.addObject(VAR_DATA_ATUAL, Calendar.getInstance().getTime());
			modelAndView.addObject(VAR_REGISTRO_ALUNO, registro.getRegistroAluno());
			return modelAndView;
		}
		
		modelAndView = new ModelAndView("redirect:/home");
		
		Registro registroAtual = registroDAO.buscaRegistro(registro.getRegistroAluno(), StatusRegistro.ATIVO.getCodigoStatus());
		registroAtual.setDataSaida(Calendar.getInstance());
		registroAtual.setHorarioSaida(registro.getHorario());
		registroAtual.setStatus(StatusRegistro.FECHADO.getCodigoStatus());
		
		registroDAO.atualiza(registroAtual);
		redirectAttributes.addFlashAttribute("mensagemSucesso", "Registro de saída concluído para o aluno " + registro.getRegistroAluno());
		return modelAndView;
	}

}
