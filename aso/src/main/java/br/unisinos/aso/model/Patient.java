package br.unisinos.aso.model;

import java.util.List;

import javax.persistence.*;


public class Patient {
	private int id;
	private DemographicalIdentification identification;
	private List<Disease> disease;
	private List<Treatment> treatment;
	
	public int getId() {
		return id;
	}
	public DemographicalIdentification getIdentification() {
		return identification;
	}
	public void setIdentification(DemographicalIdentification identification) {
		this.identification = identification;
	}
	
	@ManyToMany
	@JoinTable(name = "patient_disease", joinColumns = { @JoinColumn(name = "patient_id") }, inverseJoinColumns = { @JoinColumn(name = "disease_id") })
	public List<Disease> getDisease() {
		return disease;
	}
	public void setDisease(List<Disease> disease) {
		this.disease = disease;
	}
	
	@ManyToMany
	@JoinTable(name = "patient_treatment", joinColumns = { @JoinColumn(name = "patient_id") }, inverseJoinColumns = { @JoinColumn(name = "treatment_id") })
	public List<Treatment> getTreatment() {
		return treatment;
	}
	public void setTreatment(List<Treatment> treatment) {
		this.treatment = treatment;
	}
}