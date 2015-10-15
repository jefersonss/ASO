package br.unisinos.aso.model;

import java.sql.Date;
import java.util.*;

import javax.persistence.*;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "patient_disease", joinColumns = { @JoinColumn(name = "patient_id") }, inverseJoinColumns = { @JoinColumn(name = "disease_id") })
	private List<Disease> diseases;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "patient_treatment", joinColumns = { @JoinColumn(name = "patient_id") }, inverseJoinColumns = { @JoinColumn(name = "treatment_id") })
	private List<Treatment> treatment;
	private String name;
	private String room;
	private int age;
	private String gender;
	private Date lastEnteredDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Disease> getDiseases() {
		return diseases;
	}
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
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
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
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
	
	public List<Exam> getAllExams() {
		List<Exam> allExams = new LinkedList<Exam>();
		
		for(Treatment treatment : getTreatment()){
			allExams.addAll(treatment.getExam());
		}
		return allExams;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", disease=" + diseases + ", treatment="
				+ treatment + ", name=" + name + ", age=" + age + ", gender="
				+ gender + "]";
	}
}