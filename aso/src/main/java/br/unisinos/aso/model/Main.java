package br.unisinos.aso.model;

import java.util.List;

import br.unisinos.aso.dao.PatientDAO;

public class Main {

	public static void main(String[] args) {
		PatientDAO dao = new PatientDAO();
//		DiseaseDAO diseaseDao = new DiseaseDAO();
//		ExamDAO examDao = new ExamDAO();
//		MedicationDAO medDao = new MedicationDAO();
//		
//		Patient patient = new Patient();
//		patient.setAge(25);
//		patient.setGender("F");
//		patient.setName("Mariazinha");
//		
//		Disease disease = new Disease();
//		disease.setName("Cancer");
//		patient.setDisease(Arrays.asList(disease));
//		diseaseDao.saveDisease(disease);
//		
//		Treatment treatment = new Treatment();
//		treatment.setObservations("Cancer in the lungs due to cigarrete");
//		
//		Exam exam = new Exam();
//		exam.setName("Radiography");
//		examDao.saveExam(exam);
//		treatment.setExam(Arrays.asList(exam));
//		
//		Medication admMedication = new Medication();
//		admMedication.setName("Radiotherapy");
//		admMedication.setType("Procedure");
//		medDao.save(admMedication);
//		treatment.setAdministeredMedication(Arrays.asList(admMedication));
//		
//		Medication recMedication = new Medication();
//		recMedication.setName("Quimiotherapy");
//		recMedication.setType("Procedure");
//		medDao.save(recMedication);
//		treatment.setRecommendedMedication(Arrays.asList(recMedication));
//		
//		patient.setTreatment(Arrays.asList(treatment));
//		
//		dao.savePatient(patient);
//		
//		
//		
//		Patient patient2 = new Patient();
//		patient2.setAge(23);
//		patient2.setGender("M");
//		patient2.setName("Joazinho");
//		dao.savePatient(patient2);
//		
//		
//		dao.commitAndCloseConnection();
		
		List<Patient> patients = dao.getPatients();
		System.out.println(patients);
		
	}
}