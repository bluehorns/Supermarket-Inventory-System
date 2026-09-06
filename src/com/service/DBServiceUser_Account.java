package com.service;
	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.DatabaseObject;
import com.model.User_Account;

public class DBServiceUser_Account implements DatabaseService {
	private DatabaseConnection dbCon = new DatabaseConnection();
	
	@Override
	public void addRecord(DatabaseObject record)  {
		User_Account tempaccount = (User_Account) record;
		String sql = "Insert into user_account(user_name,user_id,password_hash,password_salt) values(?,?,?,?)";
		PreparedStatement stm;
		try {
			dbCon.createConnection();
			stm = dbCon.getConnection().prepareStatement(sql);
			stm.setString(1, tempaccount.getUsername());
			stm.setInt(2, tempaccount.getUserid());
			stm.setBytes(3, tempaccount.getPasswordHash());
			stm.setBytes(4, tempaccount.getSalt());
			stm.execute();
			dbCon.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Override
	public void deleteRecord(DatabaseObject record) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<User_Account> fetchRecord() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User_Account fetchRecord(String username) {
		String sql = "Select * from user_account where user_name = ?";
		User_Account tempAccount = new User_Account();
		try {
			dbCon.createConnection();
			PreparedStatement stm = dbCon.getConnection().prepareStatement(sql);
			stm.setString(1, username);
			ResultSet rs = stm.executeQuery();
			tempAccount = parseResultSet(rs);
			dbCon.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempAccount;
	}
	
	@Override
	public void updateRecord(DatabaseObject record) {
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
	
}
