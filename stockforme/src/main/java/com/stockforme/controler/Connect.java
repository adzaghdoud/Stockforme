package com.stockforme.controler;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stockforme.configuration.AppConfig;
import com.stockforme.model.Commande;
import com.stockforme.service.CommandeService;
import com.stockforme.service.LoginsService;

@Controller
public class Connect {
	//@RequestMapping("/login")
		
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
	
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	
	@RequestMapping(value = "/dashbord", method = RequestMethod.POST)
	public ModelAndView check(@RequestParam("login") String login,@RequestParam("password") String password) {	
	    AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    LoginsService service = (LoginsService) context.getBean("loginservice");    
	    if (service.chercher(login, password)) {
	    ModelAndView mv = new ModelAndView("main");
	    mv.addObject("welcome", "User connecté :"+login);
	    return mv;
	    }
	    else {
	    	ModelAndView mv = new ModelAndView("login");
	    	mv.addObject("msg", "Mot de passe ou user invalide");
	    	
	    	return mv;
	    }
	    

	
	
	}
	
	
	
	

}
	

