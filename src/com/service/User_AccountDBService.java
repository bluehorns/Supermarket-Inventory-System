package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.User_Account;

public class User_AccountDBService implements DatabaseService<User_Account> {
	private Connection con;
	
	@Override
	public void addRecord(User_Account record) {
		connectToDB();
		String sql = "Insert into user_account(user_name,user_id,password_hash,password_salt) values(?,?,?,?)";
		User_Account tempAccount = new User_Account();
		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, record.getUsername());
			stm.setInt(2, record.getUserid());
			stm.setBytes(3, record.getPasswordHash());
			stm.setBytes(4, record.getSalt());
			stm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
	}
	
	@Override
	public void deleteRecord(User_Account type) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<User_Account> fetchRecord() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User_Account fetchRecord(String username) {
		connectToDB();
		String sql = "Select * from user_account where user_name = ?";
		User_Account tempAccount = new User_Account();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, username);
			ResultSet rs = stm.executeQuery();
			tempAccount = parseResultSet(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
		return tempAccount;
	}
	
	@Override
	public void updateRecord(User_Account type) {
		// TODO Auto-generated method stub
		
	}
	
	private User_Account parseResultSet(ResultSet rs) {
		User_Account tempAccount = new User_Account();
		try {
			rs.next();
			tempAccount.setUserid(rs.getInt("user_id"));
			tempAccount.setUsername(rs.getString("user_name"));
			tempAccount.setSalt(rs.getBytes("password_salt"));
			tempAccount.setPasswordHash(rs.getBytes("password_hash"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempAccount;
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
