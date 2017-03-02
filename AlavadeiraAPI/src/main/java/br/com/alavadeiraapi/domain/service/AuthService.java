package br.com.alavadeiraapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.alavadeiraapi.domain.Auth;
import br.com.alavadeiraapi.domain.DAO.AuthDAO;

import org.springframework.stereotype.Component;

@Component
public class AuthService {
	@Autowired
	private AuthDAO db;

	// Busca uma autenticação pelo id
	public Auth getAuth(Integer id_driver) {
		return db.getAuthByIdDriver(id_driver);
	}
	
	// Busca uma autenticação pelo token
	public Auth getAuthByToken(String token) {
		return db.getAuthByToken(token);
	}

	// salva ou atualiza uma autenticação
	@Transactional(rollbackFor = Exception.class)
	public boolean save(Auth auth) {
		db.saveOrUpdate(auth);
		return true;
	}
	
	
}
