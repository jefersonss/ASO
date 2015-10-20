package br.unisinos.aso.dao;

import java.util.LinkedList;
import java.util.List;

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
	
	public List<Integer> getPatientsTakingSameMedication(List<Medication> medications){
		Session session = this.sessionFactory.openSession();
        
		String sql = "SELECT p.* FROM Patient p, Medication m, Administered_Medication am "
				+ "WHERE am.patient_id = p.id "
				+ "AND am.medication_id = m.id "
				+ "AND m.name in (:medication_name)";
		
		Query sqlQuery = session.createSQLQuery(sql).setParameter("medication_name", buildMedicationListNames(medications));
		List<Integer> patientIds = buildPatientList(sqlQuery.list());
		session.close();
		return patientIds;
	}
	
	private String buildMedicationListNames(List<Medication> medications) {
		StringBuilder medicationNames = new StringBuilder();
		
		for (Medication medication : medications)
			medicationNames.append(medication.getName()).append(",");
		
		return medicationNames.substring(0, medicationNames.length()-1);
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