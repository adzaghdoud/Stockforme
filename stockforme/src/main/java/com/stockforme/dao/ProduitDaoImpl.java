package com.stockforme.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.stockforme.model.Commande;
import com.stockforme.model.Produit;


@Repository("ProduitDao")
public class ProduitDaoImpl extends AbstractDao implements ProduitDao{

	public List<Produit> lister() {
		// TODO Auto-generated method stub
		 Criteria criteria = getSession().createCriteria(Produit.class);
	        return (List<Produit>) criteria.list();
	}

	

	public Produit checherproduit(int id) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Produit.class);
		criteria.add(Restrictions.eq("id",id));
		return  (Produit) criteria.uniqueResult();
	}

	public boolean ajouter(Produit produit) {
		// TODO Auto-generated method stub
		persist(produit);
		return true;
	}

	public void supprimer(int id) {
		// TODO Auto-generated method stub
		
	}

	public boolean checkstockproduit(int id, int quant) {
		// TODO Auto-generated method stub
		boolean flag= false;
		Criteria criteria = getSession().createCriteria(Produit.class);
        criteria.add(Restrictions.eq("id",id));
        Produit res=(Produit) criteria.uniqueResult();

		if (res.getStock()-quant>0) {
		flag=true;	
			
		}	
		else {
		flag=false;	
			
		}
		return flag;
	}

	public boolean reduceproduct(int id, int number) {
		// TODO Auto-generated method stub
		return false;
	}

	public double getunitprice(int id) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Produit.class);
        criteria.add(Restrictions.eq("id",id));
        Produit res=(Produit) criteria.uniqueResult();
        return res.getPuv();
	}

	public double getuntitpriceachat(int id) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Produit.class);
        criteria.add(Restrictions.eq("id",id));
        Produit res=(Produit) criteria.uniqueResult();
        return res.getPua();
	}

	public String getlibproduit(int d) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Produit.class);
        criteria.add(Restrictions.eq("id",d));
        Produit res=(Produit) criteria.uniqueResult();
        return res.getLibproduit();
	}

	public boolean updatestock(int codeproduit, int stock) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("update produit set stock = '"+stock+"' where code_produit = '" + codeproduit +"';");
		int status=query.executeUpdate();
		boolean flag=false;
		if (status >0) {
		flag=true;	
			
		}
		else {
			
			flag=false;
		}
		return flag;
	}

	public List<Produit> stock() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Produit.class);
        return (List<Produit>) criteria.list();
	}

}
