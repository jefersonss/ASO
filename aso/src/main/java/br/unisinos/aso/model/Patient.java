package br.unisinos.aso.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "patient_disease", joinColumns = { @JoinColumn(name = "patient_id") }, inverseJoinColumns = { @JoinColumn(name = "disease_id") })
	private List<Disease> disease;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "patient_treatment", joinColumns = { @JoinColumn(name = "patient_id") }, inverseJoinColumns = { @JoinColumn(name = "treatment_id") })
	private List<Treatment> treatment;
	private String name;
	private int age;
	private String gender;
	private Date lastEnteredDate;
	
	public int getId() {
		return id;
	}
	public List<Disease> getDisease() {
		return disease;
	}
	public void setDisease(List<Disease> disease) {
		this.disease = disease;
	}
	public List<Treatment> getTreatment() {
		return treatment;
	}
	public void setTreatment(List<Treatment> treatment) {
		this.treatment = treatment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getLastEnteredDate() {
		return lastEnteredDate;
	}
	public void setLastEnteredDate(Date lastEnteredDate) {
		this.lastEnteredDate = lastEnteredDate;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", disease=" + disease + ", treatment="
				+ treatment + ", name=" + name + ", age=" + age + ", gender="
				+ gender + "]";
	}
}