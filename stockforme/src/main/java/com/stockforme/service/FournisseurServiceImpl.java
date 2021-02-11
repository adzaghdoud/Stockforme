package com.stockforme.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockforme.dao.CommandeDao;
import com.stockforme.dao.FournisseurDao;
import com.stockforme.model.Fournisseur;
@Service("FournisseurService")
@Transactional
public class FournisseurServiceImpl implements FournisseurService {
	@Autowired
    private FournisseurDao dao;
	public List<Fournisseur> lister() {
		// TODO Auto-generated method stub
		return dao.lister();
	}
	@Override
	public Fournisseur checherf(int id) {
		// TODO Auto-generated method stub
		return dao.checherf(id);
	}
	@Override
	public void updatefournisseur(int id, String nom, String adresse, String tel, String iban, String siret) {
		// TODO Auto-generated method stub
		dao.updatefournisseur(id, nom, adresse, tel, iban, siret);
	}

}
