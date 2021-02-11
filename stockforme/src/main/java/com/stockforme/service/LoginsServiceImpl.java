package com.stockforme.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockforme.dao.LoginsDao;

@Service("loginservice")
@Transactional
public class LoginsServiceImpl implements LoginsService {
	@Autowired
	private LoginsDao logindao;
	public boolean chercher(String login, String motdepasse) {
		// TODO Auto-generated method stub
		
		return logindao.chercher(login, motdepasse);
	
	}

	public void resetpassword(String login, String password) {
		// TODO Auto-generated method stub
		logindao.resetpassword(login, password);
	}

}
