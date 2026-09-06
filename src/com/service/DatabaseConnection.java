package com.service;

import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection conn;
	
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			//DriverManager.registerDriver(new );
//		}
//		catch(NullPointerException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void createConnection() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","1234");
	}
	

	public Connection getConnection() throws SQLException{
		return conn;
	}
	
	public void closeConnection() throws SQLException {
		conn.close();
	}
	
}
