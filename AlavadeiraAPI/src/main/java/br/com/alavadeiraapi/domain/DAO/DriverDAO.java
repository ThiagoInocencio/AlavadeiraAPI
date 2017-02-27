package br.com.alavadeiraapi.domain.DAO;


import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.com.alavadeiraapi.domain.Driver;

@Component
public class DriverDAO extends HibernateDAO<Driver> {

	public DriverDAO() {
		// Informa o tipo da entidade para o Hibernate
		super(Driver.class);
	}
	
	// Insere ou atualiza um driver
	public void salvar(Driver c) {
		super.save(c);
	}
	
	// Busca um carro pelo nome
	public Driver getDriverByEmail(String email) {
		Query q = getSession().createQuery("from Driver where lower(email)  like lower(?)");
		q.setString(0, "%" + email +"%");
		return (Driver) q.uniqueResult();
	}
	
	// Busca um carro pelo nome
	public Driver getDriverByEmailPassword(String email, String senha) {
		Query q = getSession().createQuery("from Driver where lower(email)  like lower(?) and password = ?");
		q.setString(0, "%" + email +"%");
		q.setString(1,  senha );
		return (Driver) q.uniqueResult();
	}
	
	

}
