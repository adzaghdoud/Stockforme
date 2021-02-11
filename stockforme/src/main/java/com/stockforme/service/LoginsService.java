package com.stockforme.service;

public interface LoginsService {
	boolean chercher( String login , String motdepasse);
	void resetpassword (String login , String password);


}
