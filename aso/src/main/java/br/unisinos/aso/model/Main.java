package br.unisinos.aso.model;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.unisinos.aso.dao.PatientDAO;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Date today = new Date(new java.util.Date().getTime());
		
		Patient patient = new Patient();
		patient.setAge(25);
		patient.setGender("F");
		patient.setName("Mariazinha");
		patient.setLastEnteredDate(today);
		
		Disease disease = new Disease();
		disease.setName("Cancer");
		patient.setDiseases(Arrays.asList(disease));
		
		Treatment treatment = new Treatment();
		treatment.setObservations("Cancer in the lungs due to cigarrete");
		
		Exam exam = new Exam();
		exam.setName("Arterial diastolic pressure");
		DateTime jodaTime = new DateTime(today.getTime());
		exam.setDate(today);
		exam.setResults("15");
		
		Exam exam2 = new Exam();
		exam2.setName("Arterial systolic pressure");
		exam2.setDate(today);
		exam2.setResults("8");
		
		Exam exam3 = new Exam();
		exam3.setName("Arterial diastolic pressure");
		exam3.setDate(new Date(jodaTime.minusDays(1).getMillis()));
		exam3.setResults("12");
		
		Exam exam4 = new Exam();
		exam4.setName("Arterial systolic pressure");
		exam4.setDate(new Date(jodaTime.minusDays(1).getMillis()));
		exam4.setResults("8");
		
		Exam exam5 = new Exam();
		exam5.setName("Arterial diastolic pressure");
		exam5.setDate(new Date(jodaTime.minusDays(2).getMillis()));
		exam5.setResults("17");
		
		Exam exam6 = new Exam();
		exam6.setName("Arterial systolic pressure");
		exam6.setDate(new Date(jodaTime.minusDays(2).getMillis()));
		exam6.setResults("10");
		
		treatment.setExam(Arrays.asList(exam, exam2, exam3, exam4, exam5, exam6));
		
		Medication admMedication = new Medication();
		admMedication.setName("Celestamine");
		admMedication.setType("Xarope");
		admMedication.setDateAdministered(today);
		patient.setAdministeredMedication(Arrays.asList(admMedication));
		
		Medication recMedication = new Medication();
		recMedication.setName("Dipirona");
		recMedication.setType("Pills");
		recMedication.setDateAdministered(today);
		patient.setRecommendedMedication(Arrays.asList(recMedication));
		
		patient.setTreatment(Arrays.asList(treatment));
		
		PatientDAO dao = context.getBean(PatientDAO.class);

		
		dao.savePatient(patient);
		

		
		Patient patient2 = new Patient();
		patient2.setAge(28);
		patient2.setGender("M");
		patient2.setName("Joazinho");
		patient2.setLastEnteredDate(today);
		
		
		Treatment treatment2 = new Treatment();
		treatment2.setObservations("Cancer in the lungs due to cigarrete");
		
		Exam exam7 = new Exam();
		exam7.setName("Arterial diastolic pressure");
		DateTime jodaTime2 = new DateTime(today.getTime());
		exam7.setDate(today);
		exam7.setResults("12");
		
		Exam exam8 = new Exam();
		exam8.setName("Arterial systolic pressure");
		exam8.setDate(today);
		exam8.setResults("8");
		
		Exam exam9 = new Exam();
		exam9.setName("Arterial diastolic pressure");
		exam9.setDate(new Date(jodaTime2.minusDays(1).getMillis()));
		exam9.setResults("13");
		
		Exam exam10 = new Exam();
		exam10.setName("Arterial systolic pressure");
		exam10.setDate(new Date(jodaTime2.minusDays(1).getMillis()));
		exam10.setResults("10");
		
		Exam exam11 = new Exam();
		exam11.setName("Arterial diastolic pressure");
		exam11.setDate(new Date(jodaTime2.minusDays(2).getMillis()));
		exam11.setResults("20");
		
		Exam exam12 = new Exam();
		exam12.setName("Arterial systolic pressure");
		exam12.setDate(new Date(jodaTime2.minusDays(2).getMillis()));
		exam12.setResults("15");
		
		treatment2.setExam(Arrays.asList(exam7, exam8, exam9, exam10, exam11, exam12));
		
		Medication admMedication2 = new Medication();
		admMedication2.setName("Celestamine");
		admMedication2.setType("Xarope");
		admMedication2.setDateAdministered(today);
		patient2.setAdministeredMedication(Arrays.asList(admMedication2));
		
		Medication recMedication2 = new Medication();
		recMedication2.setName("Dipirona");
		recMedication2.setType("Pills");
		recMedication2.setDateAdministered(today);
		patient2.setRecommendedMedication(Arrays.asList(recMedication2));
		
		patient2.setTreatment(Arrays.asList(treatment2));
		
		
		dao.savePatient(patient2);
		
//		DiseaseDAO diseaseDao = context.getBean(DiseaseDAO.class);
//		diseaseDao.retrievePatientCountByDisease();
		
		context.close();
//		dao.commitAndCloseConnection();
		
//		List<Patient> patients = dao.getPatients();
//		System.out.println(patients);
		
	}
}