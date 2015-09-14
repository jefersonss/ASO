package br.unisinos.aso.model;

public class Treatment {
	private Exam exam;
	private String observations;
	private Medication recommendedMedication;
	private Medication administeredMedication;
	
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
	public Medication getRecommendedMedication() {
		return recommendedMedication;
	}
	public void setRecommendedMedication(Medication recommendedMedication) {
		this.recommendedMedication = recommendedMedication;
	}
	public Medication getAdministeredMedication() {
		return administeredMedication;
	}
	public void setAdministeredMedication(Medication administeredMedication) {
		this.administeredMedication = administeredMedication;
	}
}