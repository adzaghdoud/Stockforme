package com.stockforme.service;

import java.util.List;

import com.stockforme.model.Client;

public interface ClientService {
	void ajouter( Client client , String s) ;
    List<Client> lister() ;
    List<Client> chercher(Client utilisateur);
	List<Client> chercherparmail(String mail) ;
	List<Client> chercherbymail(String mail) ;
	List<Client> chercherparnom(String nom) ;;

}
