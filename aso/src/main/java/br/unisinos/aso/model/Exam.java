package br.unisinos.aso.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Exam {
	@Id
	private int id;
	private String name;

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}