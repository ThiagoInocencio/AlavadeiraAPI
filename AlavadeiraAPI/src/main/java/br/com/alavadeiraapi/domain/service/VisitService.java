package br.com.alavadeiraapi.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.alavadeiraapi.domain.Visit;
import br.com.alavadeiraapi.domain.DAO.VisitDAO;

@Component
public class VisitService {
	@Autowired
	private VisitDAO db;

	// Busca uma visita por id
	public Visit getAuth(Integer id_visit) {
		return db.getAuthBy(id_visit);
	}
	
	// Busca uma visita pelo ID do motorista e pela data
	public List<Visit> getVisitByIdDriverAndDate(Integer id_driver, String date) {
		return db.getVisitByIdDriverAndDate(id_driver, date);
	}

	// Salva ou atualiza uma visita
	@Transactional(rollbackFor = Exception.class)
	public boolean save(Visit visit) {
		db.saveOrUpdate(visit);
		return true;
	}
	
}
