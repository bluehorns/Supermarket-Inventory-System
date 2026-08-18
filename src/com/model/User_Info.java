package com.model;

public class User_Info {
	private int userID;
	private String userFirstName;
	private String userLastName;
	private enum userTypeE{
		CUSTOMER, 
		EMPLOYEE, 
		ADMIN;
	}
	private userTypeE userType;
	
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
	
	public void setUserType(String userTypeSwitch) {
		switch(userTypeSwitch.toUpperCase()) {
		case "CUSTOMER":
			userType = userTypeE.CUSTOMER;
			break;
			
		case "ADMIN":
			userType = userTypeE.ADMIN;
			break;
			
		case "EMPLOYEE":
			userType = userTypeE.EMPLOYEE;
			break;
			
		default:
			userType = userTypeE.CUSTOMER;
			break;
		}
	}

	public String getUserType() {
		return userType.toString();
	}
	

	
}
