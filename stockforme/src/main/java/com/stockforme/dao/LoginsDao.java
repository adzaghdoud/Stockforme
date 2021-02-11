package com.stockforme.dao;

public interface LoginsDao {
	boolean chercher( String login , String motdepasse);
	void resetpassword (String login , String password);

}
