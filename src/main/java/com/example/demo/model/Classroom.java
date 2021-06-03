package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Classroom {
	
	@Id
	private int id;
	private int classe;
	private String sezione;
	
	public Classroom() {
		
	}
	
	public Classroom(int id, int classe, String sezione) {
		this.id = id;
		this.classe = classe;
		this.sezione = sezione;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getClasse() {
		return classe;
	}
	
	public void setClasse(int classe) {
		this.classe = classe;
	}
	
	public String getSezione() {
		return sezione;
	}
	
	public void setSezione(String sezione) {
		this.sezione = sezione;
	}
	
	
}
