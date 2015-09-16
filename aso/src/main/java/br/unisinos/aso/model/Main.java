package br.unisinos.aso.model;

import java.util.List;

import br.unisinos.aso.dao.PatientDAO;

public class Main {

	public static void main(String[] args) {
		PatientDAO dao = new PatientDAO();
//		Patient patient = new Patient();
//		patient.setAge(25);
//		patient.setGender("F");
//		patient.setName("Joazinho");
//		dao.savePatient(patient);
		
//		Patient patient2 = new Patient();
//		patient2.setAge(23);
//		patient2.setGender("M");
//		patient2.setName("Joazinho");
//		dao.savePatient(patient2);
		
		List<Patient> patient = dao.getPatients();
		System.out.println(patient);
		
		dao.commitAndCloseConnection();
	}

}