package br.unisinos.aso.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medication {
	@Id
	private int id;
	private String name;
	private String type;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	} 
}