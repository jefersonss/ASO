package br.unisinos.aso.dao;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.unisinos.aso.model.Disease;
import br.unisinos.aso.model.Patient;

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
	
	public List<Integer> getPatientsWithDisease(Disease disease){
		Session session = this.sessionFactory.openSession();
		String sql = "SELECT p.* FROM Patient p, Patient_Disease pd, Disease d "
				+ "WHERE p.id = pd.patient_id "
				+ " AND pd.disease_id = d.id "
				+ " AND d.id = :disease_id";
		
		Query sqlQuery = session.createSQLQuery(sql).setParameter("disease_id", disease.getId());
		return buildPatientList(sqlQuery.list());
	}
	
	@SuppressWarnings("rawtypes")
	private List<Integer> buildPatientList(List list) {
		List<Integer> builtPatientList = new LinkedList<Integer>();
		
		for(Object patientObject : list){
			Object[] objectArray = (Object[]) patientObject;
			
			builtPatientList.add((Integer) objectArray[0]);
		}
		return builtPatientList;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}