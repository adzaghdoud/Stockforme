package com.stockforme.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
@Repository("LoginsDao")
public class LoginsDaoImpl extends AbstractDao implements LoginsDao{

	public boolean chercher(String login, String motdepasse) {
		boolean flag=false;
		Query query = getSession().createSQLQuery("select login from  logins where login = '" + login +"' and password = MD5('"+motdepasse+"');");
		// TODO Auto-generated method stub
		List<String> results = query.list();
		if (results.size() > 0) {
	    	flag=true;
	    }
	    else {
	    	
	    flag=false;	
	    }
	    return flag;
	}

	public void resetpassword(String login, String password) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("update logins set password= MD5('"+password+"') where login = '" + login +"';");
		query.executeUpdate();
		
	}

}
