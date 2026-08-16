package com.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


import com.model.Sales;

public class SalesDBService implements DatabaseService<Sales> {
	
	private Connection con;
	private int generatedId;
	private List<Sales> saleList = new ArrayList<>();
	
	@Override
	public void addRecord(Sales record) {
		try {
		connectToDB();
		String sql = "INSERT into sales(sale_date,sale_time,employee_id)"
				+ "VALUES(?,?,?)";
		PreparedStatement stm = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		stm.setDate(1, Date.valueOf(record.getSaleDate()));
		stm.setTime(2, Time.valueOf(record.getSaleTime()));
		stm.setInt(3, 5);
		stm.executeUpdate();
		ResultSet rs = stm.getGeneratedKeys();
		rs.next();
		generatedId = rs.getInt(1);
		closeDB();
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	@Override
	public void deleteRecord(Sales type) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Sales> fetchRecord() {
		connectToDB();
		String sql = "Select * from sales";
		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			parseResultSet(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeDB();
		return saleList;
	}
	
	
	
	@Override
	public void updateRecord(Sales type) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory","root","1234");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException s) {
			s.printStackTrace();
		}
		
	}
	
	@Override
	public void closeDB() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getGeneratedID() {
		return generatedId;
	}
	
	private void parseResultSet(ResultSet rs) {
		try {
			while(rs.next()) {
				Sales tempSale = new Sales();
				tempSale.setSalesId(rs.getInt("sale_id"));
				tempSale.setEmployeeId(rs.getInt("employee_id"));
				tempSale.setSaleTime(rs.getTime("sale_time").toLocalTime());
				tempSale.setSaleDate(rs.getDate("sale_date").toLocalDate());
				saleList.add(tempSale);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
