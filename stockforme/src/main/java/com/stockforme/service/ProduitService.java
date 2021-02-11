package com.stockforme.service;

import java.util.List;

import com.stockforme.model.Produit;

public interface ProduitService {
	List<Produit> lister() ;
	List<Produit> stock();
	Produit checherproduit (int id);
	boolean ajouter(Produit produit);
	void supprimer (int id);
	boolean checkstockproduit (int id,int quant );
	boolean reduceproduct (int id , int number);
	double getunitprice(int id);
	double getuntitpriceachat (int id);
	String getlibproduit(int d);
	boolean updatestock(int codeproduit, int stock);

}
