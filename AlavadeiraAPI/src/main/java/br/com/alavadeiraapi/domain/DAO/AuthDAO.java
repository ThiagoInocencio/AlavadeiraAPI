package br.com.alavadeiraapi.domain.DAO;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.com.alavadeiraapi.domain.Auth;

@Component
public class AuthDAO extends HibernateDAO<Auth> {
	public AuthDAO() {
		// Informa o tipo da entidade para o Hibernate
		super(Auth.class);
	}

	// Consulta uma authenticação pelo ID
	public Auth getAuthBy(Integer id) {
		// O Hibernate consulta automaticamente pelo id
		return super.get(id);
	}
	
	// Busca uma autenticação pelo id do motorista
	public Auth getAuthByIdDriver(Integer id_driver) {
		Query q = getSession().createQuery("from Auth where id_driver=?");
		q.setInteger(0, id_driver);
		return (Auth) q.uniqueResult();
	}
	
	// Busca uma autenticação pelo token
	public Auth getAuthByToken(String token) {
		Query q = getSession().createQuery("from Auth where token= :token");
		q.setString("token", token);
		return (Auth) q.uniqueResult();
	}

	// Insere ou atualiza uma autenticação
	public void saveOrUpdate(Auth c) {
		super.save(c);
	}
}
