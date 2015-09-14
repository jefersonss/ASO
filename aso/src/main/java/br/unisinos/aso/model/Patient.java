package br.unisinos.aso.model;

public class Patient {
	private int id;
	private DemographicalIdentification identification;
	private Disease disease;
	private Treatment treatment;
	
	public int getId() {
		return id;
	}
	public DemographicalIdentification getIdentification() {
		return identification;
	}
	public void setIdentification(DemographicalIdentification identification) {
		this.identification = identification;
	}
	public Disease getDisease() {
		return disease;
	}
	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	public Treatment getTreatment() {
		return treatment;
	}
	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
}