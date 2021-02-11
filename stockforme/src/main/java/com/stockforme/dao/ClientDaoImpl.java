package com.stockforme.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.stockforme.model.Client;
@Repository("ClientDao")
public class ClientDaoImpl extends AbstractDao implements ClientDao{

	public void ajouter(Client client, String s) {
		// TODO Auto-generated method stub
		
	}

	public List<Client> lister() {
		// TODO Auto-generated method stub
		
		 Criteria criteria = getSession().createCriteria(Client.class);
	        return (List<Client>) criteria.list();
	}

	public List<Client> chercher(Client utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Client> chercherparmail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Client> chercherbymail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Client> chercherparnom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
