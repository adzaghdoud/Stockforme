package com.stockforme.dao;

import java.util.List;

import com.stockforme.model.*;


public interface ClientDao {
	void ajouter( Client client , String s) ;
    List<Client> lister() ;
    List<Client> chercher(Client utilisateur);
	List<Client> chercherparmail(String mail) ;
	List<Client> chercherbymail(String mail) ;
	List<Client> chercherparnom(String nom) ;;

}
