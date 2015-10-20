package br.unisinos.aso.summarizer;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import br.unisinos.aso.model.*;

@Component
public class Summarizer {
	
	public Patient getSummarizedPatient(Patient patient){
		DateTime today = new DateTime();
		patient.setTreatment(filterLatestTreatmentInfo(patient.getTreatment()));
		patient.setAdministeredMedication(filterLatestMedication(patient.getAdministeredMedication(), today));
		patient.setRecommendedMedication(filterLatestMedication(patient.getRecommendedMedication(), today));
		return patient;
	}

	private List<Treatment> filterLatestTreatmentInfo(List<Treatment> treatmentList) {
		DateTime today = new DateTime();
		List<Treatment> filteredList = new ArrayList<Treatment>();
		
		for (Treatment treatment : treatmentList) {
			treatment.setExam(filterLatestExams(treatment.getExam(), today));
			filteredList.add(treatment);
		}
		return filteredList;
	}

	private List<Medication> filterLatestMedication(List<Medication> medications, DateTime today) {
		List<Medication> filteredList = new ArrayList<Medication>();
		
		for (Medication medication : medications) {
			DateTime jodaTime = new DateTime(medication.getDateAdministered().getTime());
			
			//if(Days.daysBetween(jodaTime.toLocalDate(), today.toLocalDate()).getDays() <= 1)
				filteredList.add(medication);
		}
		return filteredList;
	}

	private List<Exam> filterLatestExams(List<Exam> exams, DateTime today) {
		List<Exam> filteredList = new ArrayList<Exam>();
		
		for (Exam exam : exams) {
			DateTime jodaTime = new DateTime(exam.getDate().getTime());
			
			//if(Days.daysBetween(jodaTime.toLocalDate(), today.toLocalDate()).getDays() <= 1)
				filteredList.add(exam);
		}
		return filteredList;
	}
	
}