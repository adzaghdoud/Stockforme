package com.stockforme.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.stockforme.model.Commande;
import com.stockforme.model.Fournisseur;
import com.stockforme.model.Produit;
@Repository("FournisseurDao")
public class FournisseurDaoimpl extends AbstractDao implements FournisseurDao {

	@Override
	public List<Fournisseur>  lister() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Fournisseur.class);
        return (List<Fournisseur>) criteria.list();
}

	@Override
	public Fournisseur checherf(int id) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Fournisseur.class);
		criteria.add(Restrictions.eq("id",id));
		return  (Fournisseur) criteria.uniqueResult();
	}

	@Override
	public void updatefournisseur(int id, String nom, String adresse, String tel, String iban, String siret) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("update fournisseur set adresse = '"+adresse+"', tel = '"+tel+"',iban = '"+iban+"' , siret = '"+siret+"' where id = '" + id +"';");
		query.executeUpdate();
	
	}
	}


