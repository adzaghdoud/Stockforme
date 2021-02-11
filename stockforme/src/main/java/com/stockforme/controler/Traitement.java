package com.stockforme.controler;

import java.sql.Timestamp;


import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stockforme.configuration.AppConfig;
import com.stockforme.model.Commande;
import com.stockforme.service.ClientService;
import com.stockforme.service.CommandeService;
import com.stockforme.service.LoginsService;
import com.stockforme.service.ProduitService;
@Controller
public class Traitement {
	@RequestMapping(value = "/createcommandeview", method = RequestMethod.GET)
	public ModelAndView viewcreate() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    ProduitService srvproduit = (ProduitService) context.getBean("ProduitService");  
	    ClientService srvclient = (ClientService) context.getBean("ClientService"); 
		ModelAndView mv = new ModelAndView("creercommande");
		mv.addObject("listeproduit",srvproduit.lister());
		mv.addObject("listeclient",srvclient.lister());
		return mv;
	}
	
	
	@RequestMapping(value = "/createcommande", method = RequestMethod.POST)
	public ModelAndView check(@RequestParam Map<String,String> requestParams,HttpServletRequest request,HttpServletResponse response) {	
		HashMap<String, String> erreurs = new HashMap<String, String>();
		String numclient =  requestParams.get("numclient"); 
	    String codeproduit = requestParams.get("codeproduit");
	    String Quantite = requestParams.get("quantite");
	    String modepaiement = requestParams.get("modePaiement");
	    String modelivraison = requestParams.get("modeLivraison");
	    Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
	    String numfacture="FA"+numclient+formatter.format(date);
		String DOWNLOAD_FILE_NAME="facture_"+formatter.format(date)+".pdf";
	    String FILE_TYPE = "application/pdf";
	    String reportPath = request.getServletContext().getRealPath("resources/rapports") + "\\templatepdf.jrxml";
	    String imagepath = request.getServletContext().getRealPath("resources/rapports") + "\\stockandme.png"; 
	 
	    if (numclient.isEmpty()|| modepaiement.isEmpty()|| modelivraison.isEmpty() ||   codeproduit.isEmpty()  || Quantite.isEmpty()) {
			
			if 	(numclient.isEmpty()) {
				erreurs.put("numclient", "Numero client vide");
				
			}
			
			if 	(modepaiement.isEmpty()) {
				erreurs.put("modepaiement", "Mode de paiement vide");
				
			}
			
			if 	(modelivraison.isEmpty()) {
				erreurs.put("modelivraison", "Mode de Livraison vide");		
			}
			
			
			if 	(codeproduit.isEmpty()) {
				erreurs.put("codeproduit", "Code produit est vide");		
			}
			
			if 	(Quantite.isEmpty()) {
				erreurs.put("quantite", "Quantité est vide");		
			}
	    }
			
			else {
				
				AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			    ProduitService srvproduit = (ProduitService) context.getBean("ProduitService");
			    CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
				Commande c = new Commande();
				c.setNumclient(Integer.parseInt(numclient));
				c.setNumfacture(numfacture);
				c.setCodeproduit(Integer.parseInt(codeproduit));
				c.setModePaiement(modepaiement);
				c.setModeLivraison(modelivraison);
				c.setStatutLivraison("en traitement");
				c.setStatutPaiement("en cours de validation");
				Timestamp ts=new Timestamp(date.getTime());
				c.setDate(ts);
				c.setLibproduit(srvproduit.getlibproduit(Integer.parseInt(codeproduit)));
				
				if (srvproduit.checkstockproduit(Integer.parseInt(codeproduit), Integer.parseInt(Quantite))) {
				//recup lib produit
                c.setLibproduit(srvproduit.getlibproduit(Integer.parseInt(codeproduit)));
                //recup montant produit
                c.setMontant(srvproduit.getunitprice(Integer.parseInt(codeproduit))*Integer.parseInt(Quantite));
							
				if (!srvcommande.ajouter(c)) {
					
			    erreurs.put("erreucreate", "Erreur interne Création nouvelle Commande");	
				} else {
					System.out.println("****creation product OK ....");
					/**
					//Generateinvoice g = new Generateinvoice();
				    g.setfilename(DOWNLOAD_FILE_NAME);
				    g.setFiletype(FILE_TYPE);
				    g.setNumfacture(numfacture);
				    g.setRealpath(reportPath);
				    System.out.println("****generate invoice now ....");
				    //List<Commande> lists=c;
				    List<Commande> lists = Collections.singletonList(c);
				    g.setCommande(lists);
				    g.setImagepath(imagepath);
				    g.setReponse(response);
				   g.generate(); */
				}
					
				}
				else {
					
					erreurs.put("quantitecheck", "Produit épuisé , victime de son succés");
				}
							
			}
			
		
	    ModelAndView mv = new ModelAndView("creercommande");
	    mv.addObject("erreurs", erreurs);
	    return mv;
	    }
	
	@RequestMapping(value = "/searchcommandeview", method = RequestMethod.GET)
	public ModelAndView viewsearch() {
	
		ModelAndView mv = new ModelAndView("cherchercommande");
		return mv;
	}
	
	
	@RequestMapping(value = "/getcmd", method = RequestMethod.POST)
	public ModelAndView getcmd(@RequestParam Map<String,String> requestParams) {
		ModelAndView mv = new ModelAndView("cherchercommande");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
		String numcommande = requestParams.get("numcommande");
	    String numclient = requestParams.get("numclient");
	    String datecommande = requestParams.get("datecommande");
	    
	    if (numclient.isEmpty() && numcommande.isEmpty() && datecommande.isEmpty())  {
			mv.addObject("erreurchoix", "merci de remplir au moins un champs");	
		}
	
		else {
			if (numclient.isEmpty()!= true && numcommande.isEmpty() && datecommande.isEmpty()) {
				int nclient = Integer.parseInt(numclient);
			mv.addObject("commandes", srvcommande.searchbynumclient(nclient));
			
			if (srvcommande.searchbynumclient(nclient).isEmpty()) {
				mv.addObject("noresult", "Aucune commande n'a été trouvée pour le client  " +nclient);
			}
			else {
				mv.addObject("nbresult", "Nombre trouvés : " +srvcommande.searchbynumclient(nclient).size());
			}
			}
			if (numclient.isEmpty()  && numcommande.isEmpty() !=true && datecommande.isEmpty()) {
				int ncommande = Integer.parseInt(numcommande);
				mv.addObject("commandes", srvcommande.searchbynumcommande(ncommande));
				
				if (srvcommande.searchbynumcommande(ncommande).isEmpty()) {
					mv.addObject("noresult", "Aucune commande numéro " +ncommande +" n'a été trouvée");
				}
				else {
					mv.addObject("nbresult", "Nombre trouvés : " +srvcommande.searchbynumcommande(ncommande).size());
				}
			   }
			
			if ( numclient.isEmpty()!= true && numcommande.isEmpty() !=true && datecommande.isEmpty()) {
				int ncommande = Integer.parseInt(numcommande);
				int nclient = Integer.parseInt(numclient);
				mv.addObject("commandes", srvcommande.searchbynumcommandeandnumclient(ncommande, nclient));
				if (srvcommande.searchbynumcommandeandnumclient(ncommande, nclient).isEmpty()) {
					mv.addObject("noresult", "Aucune commande trouvée ayant le numéro client " +numclient+ " et le numéro de commande " + numcommande);
				}
				else {
					mv.addObject("nbresult", "Nombre trouvés : " +srvcommande.searchbynumcommandeandnumclient(ncommande,nclient).size());	
				}
			}
			
			if ( numclient.isEmpty() && numcommande.isEmpty() && datecommande.isEmpty() !=true) {
				mv.addObject("commandes", srvcommande.searchbydatecommande(datecommande));
				if (srvcommande.searchbydatecommande(datecommande).isEmpty()) {
					mv.addObject("noresult", "Aucune commande trouvée pour la date  " + datecommande);
				}
				else {
					mv.addObject("nbresult", "Nombre trouvés : " +srvcommande.searchbydatecommande(datecommande).size());	
				}
		
			}
			
			if ( numclient.isEmpty()!= true  && numcommande.isEmpty() !=true && datecommande.isEmpty() !=true) {
				int ncommande = Integer.parseInt(numcommande);
				int nclient = Integer.parseInt(numclient);
				mv.addObject("commandes", srvcommande.searchbydateandnumclientandnumcommande(datecommande, nclient,ncommande));
				if (srvcommande.searchbydateandnumclientandnumcommande(datecommande, nclient,ncommande).isEmpty()) {
					mv.addObject("noresult", "Aucune commande trouvée");
				}
		
			}
			
			
			if ( numclient.isEmpty()  && numcommande.isEmpty() !=true && datecommande.isEmpty() !=true) {
				int ncommande = Integer.parseInt(numcommande);
				if (srvcommande.searchbydateandnumcommande(datecommande,ncommande).isEmpty()) {
					mv.addObject("noresult", "Aucune commande trouvée");
				}
				else {
					mv.addObject("commandes", srvcommande.searchbydateandnumcommande(datecommande,ncommande));
					mv.addObject("nbresult", "Nombre trouvés : " +srvcommande.searchbydateandnumcommande(datecommande,ncommande).size());
				}
		
			}
			
			if ( numclient.isEmpty() !=true  && numcommande.isEmpty() && datecommande.isEmpty() !=true) {
				int nclient = Integer.parseInt(numclient);
				mv.addObject("commandes", srvcommande.searchbydateandnumclient(datecommande,nclient));
				if (srvcommande.searchbydateandnumclient(datecommande, nclient).isEmpty()) {
					mv.addObject("noresult", "Aucune commande trouvée");
				}
			}
					
		
		}
	    
		return mv;
	}
	

	
	@RequestMapping(value = "/modifycommandeview", method = RequestMethod.GET)
	public ModelAndView viewmodify() {
	
		ModelAndView mv = new ModelAndView("modifiercommande");
		return mv;
	}
	
	@RequestMapping(value = "/getstock", method = RequestMethod.GET)
	public ModelAndView getstock() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ProduitService srvproduit = (ProduitService) context.getBean("ProduitService");
		ModelAndView mv = new ModelAndView("stock");  	
		mv.addObject("listeproduit",srvproduit.stock());
		return mv;
	}
	
	
	@RequestMapping(value = "/viewupdatestock", method = RequestMethod.GET)
	public ModelAndView viewupdatestock() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ProduitService srvproduit = (ProduitService) context.getBean("ProduitService");
		ModelAndView mv = new ModelAndView("updatestock");  	
		mv.addObject("detail",srvproduit.stock());
		return mv;
	
	}
	
	
	@RequestMapping(value = "/viewupdatestock", method = RequestMethod.POST)
	public ModelAndView checherproduit(@RequestParam Map<String,String> requestParams) {
		ModelAndView mv = new ModelAndView("updatestock"); 
		if (requestParams.get("cp").isEmpty()) {
			mv.addObject("erreur", "vous devez choisir un code produit");		
			}
			else {
				
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ProduitService srvproduit = (ProduitService) context.getBean("ProduitService");
		mv.addObject("listestock", srvproduit.checherproduit(Integer.parseInt(requestParams.get("cp"))));	 	;
			}
		return mv;
	
	}
	
	
	@RequestMapping(value = "/savemodifstock", method = RequestMethod.POST)
	public void updatestock(@RequestParam Map<String,String> requestParams) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ProduitService srvproduit = (ProduitService) context.getBean("ProduitService");
		if (srvproduit.updatestock(Integer.parseInt(requestParams.get("codeproduitajax")), Integer.parseInt(requestParams.get("stockajax")))) {
			
		System.out.println("*****modification stock OK");	
		}
		
		else {
			System.out.println("*****modification stock KO");
			
		}
		
	
	}
	
	@RequestMapping(value = "/CalculCA", method = RequestMethod.GET)
	public ModelAndView viewcalculCA() {
		ModelAndView mv = new ModelAndView("calculCA");  	
		return mv;
	
	}
	
	@RequestMapping(value = "/CalculBenef", method = RequestMethod.GET)
	public ModelAndView viewcalculBenef() {
		ModelAndView mv = new ModelAndView("calculbenef");  	
		return mv;
	
	} 
	
	@RequestMapping(value = "/CalculBenef", method = RequestMethod.POST)
	public ModelAndView wcalculbenef(@RequestParam Map<String,String> requestParams) {
		ModelAndView mv = new ModelAndView("calculbenef");
		
		HashMap<String, String> erreurs = new HashMap<String, String>();
		String datedeb=requestParams.get("datecommandedebut");
		String datefin=requestParams.get("datecommandefin");
		double benef=0;
		
		if (datedeb.isEmpty() || datefin.isEmpty() ) {
			
			if (datedeb.isEmpty() && !datefin.isEmpty())  {
			erreurs.put("datedebutvide","Merci de choisir la date de début" );	
			}
			if (!datedeb.isEmpty() && datefin.isEmpty())  {
				erreurs.put("datefinvide","Merci de choisir la date de fin" );	
				}
			if  (datedeb.isEmpty() &&datefin.isEmpty())  {
				
				erreurs.put("intervallevide","Merci de choisir l'intervalle de date" );
			}
		}
		
		else {
			AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		    CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
		    ProduitService srvproduit = (ProduitService) context.getBean("ProduitService");
			List<Commande> c = srvcommande.searchbetweentwodate(datedeb, datefin);
			 
		     
			for(int i=0; i<c.size(); i++) {
		         Commande element=c.get(i);
		         int id=element.getCodeproduit();
		         int quantite=(int) (element.getMontant()/srvproduit.getunitprice(id));
		         benef=benef+(element.getMontant()- quantite*srvproduit.getuntitpriceachat(id));
		  	 
		   }
			
			mv.addObject("nbvente", c.size());
		   }
						
		
		mv.addObject("erreur", erreurs);
		mv.addObject("benef", benef);
		
		
		return mv;
	}
	
	
	
	
	@RequestMapping(value = "/CalculCA", method = RequestMethod.POST)
	public ModelAndView wcalculCA(@RequestParam Map<String,String> requestParams) {
		ModelAndView mv = new ModelAndView("calculCA");
		
		HashMap<String, String> erreurs = new HashMap<String, String>();
		String datedeb=requestParams.get("datecommandedebut");
		String datefin=requestParams.get("datecommandefin");
		double ca = 0;
		
		if (datedeb.isEmpty() || datefin.isEmpty() ) {
			
			if (datedeb.isEmpty() && !datefin.isEmpty())  {
			erreurs.put("datedebutvide","Merci de choisir la date de début" );	
			}
			if (!datedeb.isEmpty() && datefin.isEmpty())  {
				erreurs.put("datefinvide","Merci de choisir la date de fin" );	
				}
			if  (datedeb.isEmpty() &&datefin.isEmpty())  {
				
				erreurs.put("intervallevide","Merci de choisir l'intervalle de date" );
			}
		}
		
		else {
			AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		    CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
			List<Commande> c = srvcommande.searchbetweentwodate(datedeb, datefin);
		    
			for(int i=0; i<c.size(); i++) {
		       Commande element=c.get(i);    
		       ca=ca+element.getMontant();
		    	 
		   }
						
		}
		mv.addObject("erreur", erreurs);
		mv.addObject("ca",ca);
		
			
		return mv;
	
	}
	
	
	@RequestMapping(value = "/viewcommandetomodify", method = RequestMethod.GET)
	public ModelAndView viewcommandetomodify(@RequestParam Map<String,String> requestParams) {
		ModelAndView mv = new ModelAndView("modifiercommande");
	return mv;
	}
	
	
	
	
	
	@RequestMapping(value = "/viewcommandetomodify", method = RequestMethod.POST)
	public ModelAndView getcommandetomodify(@RequestParam Map<String,String> requestParams) {
		ModelAndView mv = new ModelAndView("modifiercommande");
		
		String numclient = requestParams.get("numclient");
		String numcommande = requestParams.get("numcommande");
		String datecommande = requestParams.get("datecommande");
		if (numcommande.isEmpty())  {
			mv.addObject("erreurchoix", "Merci de saisir le numéro de commande");	
		}
	
		else {
			AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		    CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
			if (numclient.isEmpty()!= true  && datecommande.isEmpty()) {
				int nclient = Integer.parseInt(numclient);
				int ncommande = Integer.parseInt(numcommande);
				
			mv.addObject("commandes", srvcommande.searchbynumcommandeandnumclient(nclient,ncommande));
			if (srvcommande.searchbynumclient(nclient).isEmpty()) {
				mv.addObject("noresult", "Aucune commande n'a été trouvée pour le client  " +nclient +"et le numéro de commande "+ncommande);
			}
			}
			if (numclient.isEmpty()  && numcommande.isEmpty() !=true && datecommande.isEmpty()) {
				int ncommande = Integer.parseInt(numcommande);
				mv.addObject("commandes", srvcommande.searchbynumcommande(ncommande));
				
				if (srvcommande.searchbynumcommande(ncommande).isEmpty()) {
					mv.addObject("noresult", "Aucune commande numéro " +ncommande +" n'a été trouvée");
				}
				else {
					mv.addObject("nbresult", "Nombre trouvés : " +srvcommande.searchbynumcommande(ncommande).size());
				}
			   }		
			
			if ( numclient.isEmpty()!= true  && numcommande.isEmpty() !=true && datecommande.isEmpty() !=true) {
				int ncommande = Integer.parseInt(numcommande);
				int nclient = Integer.parseInt(numclient);
				mv.addObject("commandes", srvcommande.searchbydateandnumclientandnumcommande(datecommande, nclient,ncommande));
				if (srvcommande.searchbydateandnumclientandnumcommande(datecommande, nclient,ncommande).isEmpty()) {
					mv.addObject("noresult", "Aucune commande trouvée");
				}
		
			}
			
			
			if ( numclient.isEmpty()  && numcommande.isEmpty() !=true && datecommande.isEmpty() !=true) {
				int ncommande = Integer.parseInt(numcommande);
				mv.addObject("commandes", srvcommande.searchbydateandnumcommande(datecommande,ncommande));
				if (srvcommande.searchbydateandnumcommande(datecommande,ncommande).isEmpty()) {
					mv.addObject("noresult", "Aucune commande trouvée");
				}
		
			}
			
			if ( numclient.isEmpty() !=true  && numcommande.isEmpty() && datecommande.isEmpty() !=true) {
				int nclient = Integer.parseInt(numclient);
				mv.addObject("commandes", srvcommande.searchbydateandnumclient(datecommande,nclient));
				if (srvcommande.searchbydateandnumclient(datecommande, nclient).isEmpty()) {
					mv.addObject("noresult", "Aucune commande trouvée");
				}
			}
					
		
		}
		
		return mv;
	}
	
	
	
	@RequestMapping(value = "/savemodifcommande", method = RequestMethod.POST)
	public void savemodifcommande(@RequestParam Map<String,String> requestParams) {
		String numcommande = requestParams.get("numcommandeajax");
		String montant = requestParams.get("montantajax");
		String modepaiement = requestParams.get("modepaiemenajax");
		String statuspaimement = requestParams.get("statuspaiementajax");
		String modelivraison = requestParams.get("modelivraisonajax");
		String statuslivraison = requestParams.get("statuslivraisonajax"); 
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
	    if (srvcommande.updatecommande(numcommande, montant, modepaiement, statuspaimement, modelivraison, statuslivraison)) {
	    System.out.println("****update ok");	
	    	
	    }
	    
	    else {
	    	
	    	 System.out.println("****update KO");
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
