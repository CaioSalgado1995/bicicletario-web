package br.com.utfpr.bicicletario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView exibeHome() {
		return new ModelAndView("/home/index");
	}
	
}
