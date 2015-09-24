package br.unisinos.aso.dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.unisinos.aso.model.Patient;

@Repository
public class PatientDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void savePatient(Patient patient){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(patient);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Patient> searchPatientByName(String name){
		Session session = this.sessionFactory.openSession();
		String hql = "FROM Patient P WHERE P.name LIKE :patient_name";
		Query query = session.createQuery(hql).setParameter("patient_name", name+"%");
		return query.list();
	}
	
	public Patient getPatientById(int patientId){
		Session session = this.sessionFactory.openSession();
		return (Patient) session.get(Patient.class, patientId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Patient> getPatients(){
		Session session = this.sessionFactory.openSession();
		String hql = "FROM Patient";
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	public void updatePatient(Patient patient) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(patient);
		tx.commit();
		session.close();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}