package br.unisinos.aso.dao;

import java.util.List;

import org.hibernate.Query;

import br.unisinos.aso.model.Patient;

public class PatientDAO extends BaseDAO {

	public void savePatient(Patient patient){
		openConnection();
		session.save(patient);
//		commitAndCloseConnection();
	}
	
	@SuppressWarnings("unchecked")
	public List<Patient> searchPatientByName(String name){
		openConnection();
		String hql = "FROM Patient P WHERE P.name LIKE :patient_name";
		Query query = session.createQuery(hql).setParameter("patient_name", name+"%");
		return query.list();
	}
	
	public Patient getPatientById(int patientId){
		openConnection();
		return session.get(Patient.class, patientId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Patient> getPatients(){
		openConnection();
		String hql = "FROM Patient";
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	public void updatePatient(Patient patient) {
		openConnection();
		session.update(patient);
		commitAndCloseConnection();
	}
	
	@Override
	public void commitAndCloseConnection() {
		super.commitAndCloseConnection();
	}
	
	@Override
	public void openConnection() {
		super.openConnection();
	}

}