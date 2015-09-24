package br.unisinos.aso.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.unisinos.aso.model.Medication;

@Repository
public class MedicationDAO extends BaseDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Medication medication){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(medication);
		tx.commit();
		session.close();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}