package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.model.User_Info;

public class UserDBService implements DatabaseService<User_Info> {
	private Connection con;
	
	@Override
	public void addRecord(User_Info type) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteRecord(User_Info type) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateRecord(User_Info type) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<User_Info> fetchRecord() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory","root","1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void closeDB() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
