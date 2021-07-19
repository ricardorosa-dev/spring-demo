package com.example.demo.student;

public class UserStats {
	private String nameString;
	private String emailString;
	
	public UserStats(String nameString, String emailString) {
		this.nameString = nameString;
		this.emailString = emailString;
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
	
	
}
