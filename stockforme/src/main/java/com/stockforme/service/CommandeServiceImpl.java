package com.stockforme.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockforme.dao.CommandeDao;
import com.stockforme.model.Commande;
@Service("commandeservice")
@Transactional
public class CommandeServiceImpl implements CommandeService{
	@Autowired
    private CommandeDao dao;
	public boolean ajouter(Commande commande) {
		// TODO Auto-generated method stub
		dao.ajouter(commande);
		return true;
	}

	public List<Commande> lister() {
		// TODO Auto-generated method stub
		return dao.lister();
	}

	public List<Commande> searchbynumclient(int numclient) {
		// TODO Auto-generated method stub
		return dao.searchbynumclient(numclient);
	}

	public Commande searchbynumfacture(String numfacture) {
		// TODO Auto-generated method stub
		return dao.searchbynumfacture(numfacture);
	}

	public List<Commande> searchbynumcommande(int numcommande) {
		// TODO Auto-generated method stub
		return dao.searchbynumcommande(numcommande);
	}

	public List<Commande> searchbynumcommandeandnumclient(int numclient, int numcommande) {
		// TODO Auto-generated method stub
		return dao.searchbynumcommandeandnumclient(numclient, numcommande);
	}

	public List<Commande> searchbydatecommande(String datecommande) {
		// TODO Auto-generated method stub
		return dao.searchbydatecommande(datecommande);
	}

	public List<Commande> searchbydateandnumclientandnumcommande(String datecommande, int numclient, int numcommande) {
		// TODO Auto-generated method stub
		return dao.searchbydateandnumclientandnumcommande(datecommande, numclient, numcommande);
	}

	public List<Commande> searchbydateandnumcommande(String datecommande, int numcommande) {
		// TODO Auto-generated method stub
		return dao.searchbydateandnumcommande(datecommande, numcommande);
	}

	public List<Commande> searchbydateandnumclient(String datecommande, int numclient) {
		// TODO Auto-generated method stub
		return  dao.searchbydateandnumclient(datecommande, numclient);
				
	}

	public List<Commande> searchbetweentwodate(String datedeb, String datefin) {
		// TODO Auto-generated method stub
		return dao.searchbetweentwodate(datedeb, datefin);
	}

	public boolean updatecommande(String numcommmande, String montant, String modepaiement, String statuspaiement,
			String modelivraison, String statuslivraison) {
		// TODO Auto-generated method stub
		return dao.updatecommande(numcommmande, montant, modepaiement, statuspaiement, modelivraison, statuslivraison);
	}

}
