package br.com.utfpr.bicicletario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sobre")
public class SobreController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView exibeSobre() {
		return new ModelAndView("/home/sobre");
	}
	
}
