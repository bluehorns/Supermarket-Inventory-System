package com.service;

import java.sql.Connection;			
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Product;


public class DatabaseConnection {
	Connection con;
	

	public void connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory","root","1234");
		} catch (ClassNotFoundException e ) {
			e.printStackTrace();
		} catch(SQLException s) {
			s.printStackTrace();
		}
		
	}
	
//	public void executeStatement(PreparedStatement stm) {
//		try {
//			 boolean isResultSet = stm.execute();
//			 if(isResultSet) {
//				 ResultSet rs = stm.getResultSet();
//			 }else {
//				 int UpdateCount = stm.getUpdateCount();
//			 }
//		} catch (Exception e) {
//			//System.out.println(e.getClass().getCanonicalName());
//			e.printStackTrace();
//		}
//	}
//	
//	public void readResultSet(ResultSet rs) {
//		
//	}
	
	public void disconnectFromDB() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
