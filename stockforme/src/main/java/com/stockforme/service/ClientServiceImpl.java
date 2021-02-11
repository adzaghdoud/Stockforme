package com.stockforme.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockforme.dao.ClientDao;
import com.stockforme.dao.CommandeDao;
import com.stockforme.model.Client;
@Service("ClientService")
@Transactional
public class ClientServiceImpl implements ClientService {
	@Autowired
    private ClientDao dao;

	public void ajouter(Client client, String s) {
		// TODO Auto-generated method stub
		
	}

	public List<Client> lister() {
		// TODO Auto-generated method stub
		return dao.lister();
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
