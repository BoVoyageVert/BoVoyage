package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/template")
public class templateController {
	
	@RequestMapping(value = "/templateTest", method = RequestMethod.GET)
	public ModelAndView afficherAccueilClient() {
		return new ModelAndView("templateTest");
	}
	
	@RequestMapping(value = "/templateAd", method = RequestMethod.GET)
	public ModelAndView afficherAccueilAdmin() {
		return new ModelAndView("templateAd");
	}

}
