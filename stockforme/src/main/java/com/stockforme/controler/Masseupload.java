package com.stockforme.controler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.stockforme.configuration.AppConfig;
import com.stockforme.model.Commande;
import com.stockforme.model.Produit;
import com.stockforme.service.ClientService;
import com.stockforme.service.CommandeService;
import com.stockforme.service.ProduitService;

@Controller
public class Masseupload {
	
	
	@RequestMapping(value = "/uploadproduct", method = RequestMethod.GET)
	public ModelAndView viewuploadproduct() {
	
		ModelAndView mv = new ModelAndView("uploadproduct");
	
		return mv;
	}
	
	
	@RequestMapping(value = "/uploadproduct", method = RequestMethod.POST)
	public ModelAndView uploadproduct (@RequestParam MultipartFile file) throws IOException{
	
		ModelAndView mv = new ModelAndView("uploadproduct");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    ProduitService srvproduit = (ProduitService) context.getBean("ProduitService");
		

		try {

		    // String line;
		     InputStream is = file.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		     CsvToBean<Produit> csvToBean = new CsvToBeanBuilder<Produit>(reader)
	                    .withType(Produit.class)
	                    .withIgnoreLeadingWhiteSpace(true)
	                    .withSeparator(';')
	                    .build();

		     List<Produit> listeproduit = csvToBean.parse();  
		     
		     for(int i=0; i<listeproduit.size(); i++) {
		         Produit element=listeproduit.get(i);
		         if (srvproduit.ajouter(element) ) {
		         mv.addObject("erreur", "Rajout produit en  BD OK");	 
		        	 
		         }
		         else {
		        	 mv.addObject("success", "Rajout en produit en BD KO");	 
		        	 
		         }
		   }
		     
  	      
		  } catch (IOException e) {
		    System.err.println(e.getMessage());       
		  }
	    
		return mv;
	}
	
	
	
	@RequestMapping(value = "/uploadcommande", method = RequestMethod.GET)
	public ModelAndView viewuploadcommande() {
	
		ModelAndView mv = new ModelAndView("uploadcommande");
	
		return mv;
	}
	
	
	
	@RequestMapping(value = "/uploadcommande", method = RequestMethod.POST)
	public ModelAndView uploadcommande (@RequestParam MultipartFile file) throws IOException{
	
		ModelAndView mv = new ModelAndView("uploadcommande");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
		
		try {

		    // String line;
		     InputStream is = file.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		     CsvToBean<Commande> csvToBean = new CsvToBeanBuilder<Commande>(reader)
	                    .withType(Commande.class)
	                    .withIgnoreLeadingWhiteSpace(true)
	                    .withSeparator(';')
	                    .build();

		          List<Commande> listecommande = csvToBean.parse();   
		          for(int i=0; i<listecommande.size(); i++) {
				  Commande element=listecommande.get(i);         
		          Date date = new Date();
				  SimpleDateFormat formatterfacture = new SimpleDateFormat("ddMMyyyyHHmmss");
				  //SimpleDateFormat formattercmd= new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
			      String numfacture="FA"+element.getNumclient()+formatterfacture.format(date);
			      Timestamp ts=new Timestamp(date.getTime());
			      element.setNumfacture(numfacture);
			      element.setDate(ts);
			      srvcommande.ajouter(element);
	
		          }
		          
		          mv.addObject("succes","Nombre de Commande rajoutés est : "+listecommande.size());
		     
  	      
		  } catch (IOException e) {
		    System.err.println(e.getMessage());       
		  }
	    
		return mv;
	}
	
	
	

}
