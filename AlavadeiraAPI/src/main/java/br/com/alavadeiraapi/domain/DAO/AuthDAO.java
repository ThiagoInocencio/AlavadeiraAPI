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

	// Consulta um carro pelo id
	public Auth getAuthBy(Integer id) {
		// O Hibernate consulta automaticamente pelo id
		return super.get(id);
	}
	
	// Busca um carro pelo nome
		public Auth getAuthByIdDriver(Integer id_driver) {
			Query q = getSession().createQuery("from Auth where id_driver=?");
			q.setInteger(0, id_driver);
			return (Auth) q.uniqueResult();
		}

	// Insere ou atualiza um carro
	public void saveOrUpdate(Auth c) {
		super.save(c);
	}
}
