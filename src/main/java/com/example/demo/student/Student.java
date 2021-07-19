package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Student {
	
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
	)
	private Long idLong;
	private String nameString;
	private String emailString;
	private LocalDate dobDate;
	@Transient
	private Integer ageInteger;
	
	public Student() {
	}

	public Student(Long idLong, 
			String nameString, 
			String emailString, 
			LocalDate dobDate) {
		super();
		this.idLong = idLong;
		this.nameString = nameString;
		this.emailString = emailString;
		this.dobDate = dobDate;
	}

	public Student(String nameString, 
			String emailString, 
			LocalDate dobDate) {
		super();
		this.nameString = nameString;
		this.emailString = emailString;
		this.dobDate = dobDate;
	}

	public Long getIdLong() {
		return idLong;
	}

	public void setIdLong(Long idLong) {
		this.idLong = idLong;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public LocalDate getDobDate() {
		return dobDate;
	}

	public void setDobDate(LocalDate dobDate) {
		this.dobDate = dobDate;
	}

	public Integer getAgeInteger() {
		return Period.between(this.dobDate, LocalDate.now()).getYears();
	}

	public void setAgeInteger(Integer ageInteger) {
		this.ageInteger = ageInteger;
	}

	@Override
	public String toString() {
		return "Student [idLong=" + idLong + ", nameString=" + nameString + ", emailString=" + emailString
				+ ", dobDate=" + dobDate + ", ageInteger=" + ageInteger + "]";
	}
	
	
	
	
	
	
}
