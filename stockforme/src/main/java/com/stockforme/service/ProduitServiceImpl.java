package com.stockforme.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockforme.dao.CommandeDao;
import com.stockforme.dao.ProduitDao;
import com.stockforme.model.Produit;
@Service("ProduitService")
@Transactional
public class ProduitServiceImpl implements ProduitService{
	@Autowired
    private ProduitDao dao;
	public List<Produit> lister() {
		// TODO Auto-generated method stub
		return dao.lister();
	}

	public List<Produit> stock() {
		// TODO Auto-generated method stub
		return dao.stock();
	}

	public Produit checherproduit(int id) {
		// TODO Auto-generated method stub
		return dao.checherproduit(id);
	}

	public boolean ajouter(Produit produit) {
		// TODO Auto-generated method stub
		return dao.ajouter(produit);
	}

	public void supprimer(int id) {
		// TODO Auto-generated method stub
		
	}

	public boolean checkstockproduit(int id, int quant) {
		// TODO Auto-generated method stub
		return dao.checkstockproduit(id, quant);
	}

	public boolean reduceproduct(int id, int number) {
		// TODO Auto-generated method stub
		return false;
	}

	public double getunitprice(int id) {
		// TODO Auto-generated method stub
		return dao.getunitprice(id);
	}

	public double getuntitpriceachat(int id) {
		// TODO Auto-generated method stub
		return dao.getuntitpriceachat(id);
	}

	public String getlibproduit(int d) {
		// TODO Auto-generated method stub
		return dao.getlibproduit(d);
	}

	public boolean updatestock(int codeproduit, int stock) {
		return dao.updatestock(codeproduit, stock);
	}

}
