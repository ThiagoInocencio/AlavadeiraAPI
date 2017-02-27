package br.com.alavadeiraapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.alavadeiraapi.domain.Driver;
import br.com.alavadeiraapi.domain.DAO.DriverDAO;

import org.springframework.stereotype.Component;

@Component
public class DriverService {
	@Autowired
	private DriverDAO db;

	// Salva ou atualiza o carro
	@Transactional(rollbackFor = Exception.class)
	public boolean save(Driver drive) {
		db.save(drive);
		return true;
	}
	
	// Busca um motorista pelo email
	public Driver getDriver(String email) {
		return db.getDriverByEmail(email);
	}
	
	// Autenticar motorista
	public Driver loadDriver(String email, String password) {
		return db.getDriverByEmailPassword(email, password);
	}
}
