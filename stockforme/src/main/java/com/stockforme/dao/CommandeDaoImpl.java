package com.stockforme.dao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.stockforme.model.*;
@Repository("CommandeDao")
public class CommandeDaoImpl extends AbstractDao implements CommandeDao {

	public boolean ajouter(Commande commande) {
		// TODO Auto-generated method stub
		persist(commande);
		return true;
	}

	public List<Commande> lister() {
		// TODO Auto-generated method stub
		 Criteria criteria = getSession().createCriteria(Commande.class);
	        return (List<Commande>) criteria.list();
	}

	public List<Commande> searchbynumclient(int numclient) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Commande.class);
        criteria.add(Restrictions.eq("numclient",numclient));
        return (List<Commande>) criteria.uniqueResult();
	}

	public Commande searchbynumfacture(String numfacture) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Commande.class);
        criteria.add(Restrictions.eq("numfacture",numfacture));
        return (Commande) criteria.uniqueResult();
	}

	public List<Commande> searchbynumcommande(int numcommande) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Commande.class);
        criteria.add(Restrictions.eq("numcommande",numcommande));
        return (List<Commande>) criteria.list();
	}

	public List<Commande> searchbynumcommandeandnumclient(int numclient, int numcommande) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Commande.class);
        criteria.add(Restrictions.eq("numcommande",numcommande));
        criteria.add(Restrictions.eq("numclient",numclient));
        return (List<Commande>) criteria.list();
        
	}

	public List<Commande> searchbydatecommande(String datecommande) {
		// TODO Auto-generated method stub
		String expr=datecommande+"%";
		Criteria criteria = getSession().createCriteria(Commande.class);
		criteria.add(Restrictions.sqlRestriction("date_commande like '"+expr+"'"));
	    return criteria.list();
	}

	public List<Commande> searchbydateandnumclientandnumcommande(String datecommande, int numclient, int numcommande) {
		// TODO Auto-generated method stub
		String expr=datecommande+"%";
		Criteria criteria = getSession().createCriteria(Commande.class);
		criteria.add(Restrictions.sqlRestriction("date_commande like '"+expr+"'"));
		criteria.add(Restrictions.eq("numcommande", numcommande));
		criteria.add(Restrictions.eq("numclient", numclient));
	    return criteria.list();
	}

	public List<Commande> searchbydateandnumcommande(String datecommande, int numcommande) {
		// TODO Auto-generated method stub
	
		    String expr=datecommande+"%";
			Criteria criteria = getSession().createCriteria(Commande.class);
			criteria.add(Restrictions.sqlRestriction("date_commande like '"+expr+"'"));
			criteria.add(Restrictions.eq("numcommande", numcommande));
		    return criteria.list();
		
		
	}

	public List<Commande> searchbydateandnumclient(String datecommande, int numclient) {
		// TODO Auto-generated method stub
		String expr=datecommande+"%";
		Criteria criteria = getSession().createCriteria(Commande.class);
		criteria.add(Restrictions.sqlRestriction("date_commande like '"+expr+"'"));
		criteria.add(Restrictions.eq("numclient", numclient));
	    return criteria.list();
	}

	public List<Commande> searchbetweentwodate(String datedeb, String datefin)  {
		// TODO Auto-generated method stub
			Criteria criteria = getSession().createCriteria(Commande.class);
			criteria.add(Restrictions.sqlRestriction("DATE_FORMAT(date_commande, '%y-%m-%d') BETWEEN DATE_FORMAT('" + datedeb +"', '%y-%m-%d')  AND  DATE_FORMAT('" + datefin +"', '%y-%m-%d');"));			
	        System.out.println("size commande impl est "+ criteria.list());
			 return  criteria.list();
	
	}

	public boolean updatecommande(String numcommmande, String montant, String modepaiement, String statuspaiement,
			String modelivraison, String statuslivraison) {
		// TODO Auto-generated method stub
		Double montantc=Double.parseDouble(montant);
		Query query = getSession().createSQLQuery("update Commande set montant = '"+montantc+"' ,modePaiement = '"+modepaiement+"', statutPaiement = '"+statuspaiement+"' , modeLivraison = '"+modelivraison+"' , statutLivraison = '"+statuslivraison+"' where numcommande ='"+numcommmande+"' ;");
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
	}
	


