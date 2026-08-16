package com.model;

public class User_Info {
	private int userID;
	private String userFirstName;
	private String userLastName;
	private enum userType{
		CUSTOMER, 
		EMPLOYEE, 
		ADMIN;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	

	
}
