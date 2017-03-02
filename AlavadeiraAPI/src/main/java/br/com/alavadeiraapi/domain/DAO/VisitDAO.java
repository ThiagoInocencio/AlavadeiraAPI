package br.com.alavadeiraapi.domain.DAO;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.com.alavadeiraapi.domain.Visit;

@Component
public class VisitDAO extends HibernateDAO<Visit> {
	public VisitDAO() {
		// Informa o tipo da entidade para o Hibernate
		super(Visit.class);
	}

	// Consulta uma visita por id
	public Visit getAuthBy(Integer id) {
		// O Hibernate consulta automaticamente pelo id
		return super.get(id);
	}
	
	// Busca uma visita por id do motorista e pela data
	public List<Visit> getVisitByIdDriverAndDate(Integer id_driver, String date) {
		Query q = getSession().createQuery("from Visit where id_driver=? and schedule_for=?");
		q.setInteger(0, id_driver);
		q.setString(1, date);
		@SuppressWarnings("unchecked")
		List<Visit> visit = q.list();
		return visit;
	}
	
	// Insere ou atualiza uma visita
	public void saveOrUpdate(Visit c) {
		super.save(c);
	}
}
