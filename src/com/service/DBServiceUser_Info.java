package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.model.User_Info;

public class DBServiceUser_Info implements DatabaseService<User_Info> {
	private DatabaseConnection dbCon = new DatabaseConnection();
	private int userId;
	
	@Override
	public void addRecord(User_Info record) {
		String sql  = "INSERT into user_info(user_first_name,user_last_name,user_type) values(?,?,?)";
		try {
			dbCon.createConnection();
			PreparedStatement stm =  dbCon.getConnection().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setString(1, record.getUserFirstName());
			stm.setString(2, record.getUserLastName());
			stm.setString(3,record.getUserType());
			stm.executeUpdate();
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			userId = rs.getInt(1);
			dbCon.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
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
	
	public User_Info fetchRecord(int userId) {
		String sql = "Select * from user_info where user_id = ?";
		User_Info userInfo = new User_Info();
		try {
			dbCon.createConnection();
			PreparedStatement stm = dbCon.getConnection().prepareStatement(sql);
			stm.setInt(1, userId);
			ResultSet rs = stm.executeQuery();
			rs.next();
			dbCon.closeConnection();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfo;
		
	}
	
	public int getUserId() {
		return userId;
	}
}
