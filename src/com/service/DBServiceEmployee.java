package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.DatabaseObject;
import com.model.Employee;

public class DBServiceEmployee implements DatabaseService {
	private List<Employee> employeeList = new ArrayList<>();
	private DatabaseConnection dbCon = new DatabaseConnection();
	private Employee tempEmployee;
	
	@Override
	public void addRecord(DatabaseObject record) {
		tempEmployee = (Employee) record;
		String sql = "Insert into employees(employee_firstname,employee_lastname,employee_post,user_id) "
				+ "VALUES(?,?,?,?)";
		try {
			dbCon.createConnection();
			PreparedStatement stm = dbCon.getConnection().prepareStatement(sql);
			stm.setString(1, tempEmployee.getEmployeeFirstName());
			stm.setString(2, tempEmployee.getEmployeeLastName());
			stm.setString(3, tempEmployee.getEmployeePost());
			stm.setInt(4, tempEmployee.getUserID());
			stm.executeUpdate();
			dbCon.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Employee> fetchRecord() {
		String sql = "Select * from employees";
		try {
			dbCon.createConnection();
			PreparedStatement stm = dbCon.getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			processResultSet(rs);
			dbCon.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
	}
	
	
	private void processResultSet(ResultSet rs) throws SQLException {
		Employee employee;
		while(rs.next()) {
			employee = new Employee();
			employee.setEmployeeId(rs.getInt("employee_id"));
			employee.setEmployeeFirstName(rs.getString("employee_firstname"));
			employee.setEmployeePost(rs.getString("employee_post"));
			employee.setUserID(rs.getInt("user_id"));
			employeeList.add(employee);
		}
	}
	
	@Override
	public void deleteRecord(DatabaseObject record) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateRecord(DatabaseObject record) {
		// TODO Auto-generated method stub
		
	}

}
