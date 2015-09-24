package br.unisinos.aso.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.unisinos.aso.model.Disease;

@Repository
public class DiseaseDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public void saveDisease(Disease disease) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(disease);
		tx.commit();
		session.close();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}