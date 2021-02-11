package com.stockforme.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Clientcontrol {
	@RequestMapping(value = "/createclient", method = RequestMethod.GET)
	public ModelAndView viewcreateclient() {
	
		ModelAndView mv = new ModelAndView("createclient");
	
		return mv;
	}
	
	@RequestMapping(value = "/searchclient", method = RequestMethod.GET)
	public ModelAndView viewmodifyclient() {
	
		ModelAndView mv = new ModelAndView("chercherclient");
	
		return mv;
	}

}
