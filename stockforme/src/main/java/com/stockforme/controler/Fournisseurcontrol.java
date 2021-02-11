package com.stockforme.controler;

import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stockforme.configuration.AppConfig;
import com.stockforme.service.CommandeService;
import com.stockforme.service.FournisseurService;

@Controller
public class Fournisseurcontrol {
	@RequestMapping(value = "/fournisseur", method = RequestMethod.GET)
	public ModelAndView viewcreateclient() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    FournisseurService srvfournisseur = (FournisseurService) context.getBean("FournisseurService");
	
		ModelAndView mv = new ModelAndView("fournisseur");
		mv.addObject("fournisseurs", srvfournisseur.lister());
	 
		return mv;
	}
	
	
	@RequestMapping(value = "/fournisseur", method = RequestMethod.POST)
	public ModelAndView searchfournisseur(@RequestParam Map<String,String> requestParams) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    FournisseurService srvfournisseur = (FournisseurService) context.getBean("FournisseurService");
	    ModelAndView mv = new ModelAndView("fournisseur");
	    mv.addObject("fournisseurs", srvfournisseur.lister());
	    String numf = requestParams.get( "id" );
		if (numf.length()!= 0) {
		mv.addObject("fourn", srvfournisseur.checherf(Integer.parseInt(numf)));
	
		}
		
		else {
			mv.addObject("erreurchoix", "merci de choisir un numéro fournisseur");	
			
		}
	    
	
	 
		return mv;
	}

	@RequestMapping(value = "/saveupdate", method = RequestMethod.POST)
	public void saveupdatefournisseur(@RequestParam Map<String,String> requestParams) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    FournisseurService srvfournisseur = (FournisseurService) context.getBean("FournisseurService");
	    srvfournisseur.updatefournisseur(Integer.parseInt(requestParams.get("numfourajax")), requestParams.get("nomfourajax"), requestParams.get("adresseajax"), requestParams.get("telajax"), requestParams.get("ibanajax"), requestParams.get("siretajax"));		
	}
	@RequestMapping(value = "/viewsaveupdate", method = RequestMethod.GET)
	public ModelAndView viewsaveupdate() {
		ModelAndView mv = new ModelAndView("modifierfournisseur");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    FournisseurService srvfournisseur = (FournisseurService) context.getBean("FournisseurService");
	    mv.addObject("fournisseurs", srvfournisseur.lister());
		return mv;
	}
	
	
	@RequestMapping(value = "/viewsaveupdate", method = RequestMethod.POST)
	public ModelAndView viewssarchforupdate(@RequestParam Map<String,String> requestParams) {
		ModelAndView mv = new ModelAndView("modifierfournisseur");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    FournisseurService srvfournisseur = (FournisseurService) context.getBean("FournisseurService");
	    mv.addObject("fournisseurs", srvfournisseur.lister());
	    String numf = requestParams.get( "id" );
		if (numf.length()!= 0) {
		mv.addObject("fourn", srvfournisseur.checherf(Integer.parseInt(numf)));
	
		}
		
		else {
			mv.addObject("erreurchoix", "merci de choisir un numéro fournisseur");	
			
		}
	    
	
	 
		return mv;
	}
	
	
	
	}




