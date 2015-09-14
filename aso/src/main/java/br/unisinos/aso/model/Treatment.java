package br.unisinos.aso.model;

import java.util.List;

public class Treatment {
	private int id;
	private Exam exam;
	private String observations;
	private List<Medication> recommendedMedication;
	private List<Medication> administeredMedication;
	
	public int getId() {
		return id;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public List<Medication> getRecommendedMedication() {
		return recommendedMedication;
	}
	public void setRecommendedMedication(List<Medication> recommendedMedication) {
		this.recommendedMedication = recommendedMedication;
	}
	public List<Medication> getAdministeredMedication() {
		return administeredMedication;
	}
	public void setAdministeredMedication(List<Medication> administeredMedication) {
		this.administeredMedication = administeredMedication;
	}
}