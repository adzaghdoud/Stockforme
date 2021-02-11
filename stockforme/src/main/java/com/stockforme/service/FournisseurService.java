package com.stockforme.service;

import java.util.List;

import com.stockforme.model.Fournisseur;

public interface FournisseurService {
	List<Fournisseur>  lister();

	Fournisseur checherf(int id);
	void updatefournisseur(int id,String nom , String adresse , String tel , String  iban , String siret);

}
