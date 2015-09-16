package br.unisinos.aso.model;

import javax.persistence.*;


@Entity
public class Exam {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	@Override
	public String toString() {
		return "Exam [id=" + id + ", name=" + name + "]";
	}
}