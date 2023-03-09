package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student_REST")
public class Student {
	
	@Id
	@Column(name="Sid")
	private int id;
	
	@Column(name="Fname",length=15)
	private String name;
	
	@Column(name="Lname",length=15)
	private String lnme;

	@Column(name="Marks")
	private double mark;
	
	
	public Student() {
		super();
	}


	public Student(int id, String name, String lnme, double mark) {
		super();
		this.id = id;
		this.name = name;
		this.lnme = lnme;
		this.mark = mark;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLnme() {
		return lnme;
	}


	public void setLnme(String lnme) {
		this.lnme = lnme;
	}


	public double getMark() {
		return mark;
	}


	public void setMark(double mark) {
		this.mark = mark;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lnme=" + lnme + ", mark=" + mark + "]";
	}
	
	
	
}
