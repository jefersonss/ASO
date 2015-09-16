package br.unisinos.aso.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Treatment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String observations;
	@ManyToMany
	@JoinTable(name = "treat_exam", joinColumns = { @JoinColumn(name = "medication_id") }, inverseJoinColumns = { @JoinColumn(name = "exam_id") })
	private List<Exam> exam;
	@ManyToMany
	@JoinTable(name = "recomended_treat_med", joinColumns = { @JoinColumn(name = "medication_id") }, inverseJoinColumns = { @JoinColumn(name = "treatment_id") })
	private List<Medication> recommendedMedication;
	@ManyToMany
	@JoinTable(name = "administered_treat_med", joinColumns = { @JoinColumn(name = "medication_id") }, inverseJoinColumns = { @JoinColumn(name = "treatment_id") })
	private List<Medication> administeredMedication;
	
	public int getId() {
		return id;
	}
	public List<Exam> getExam() {
		return exam;
	}
	public void setExam(List<Exam> exam) {
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
	
	@Override
	public String toString() {
		return "Treatment [id=" + id + ", observations=" + observations
				+ ", exam=" + exam + ", recommendedMedication="
				+ recommendedMedication + ", administeredMedication="
				+ administeredMedication + "]";
	}
}