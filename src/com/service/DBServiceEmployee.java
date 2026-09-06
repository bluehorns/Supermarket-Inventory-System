package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

public class DBServiceEmployee implements DatabaseService<Employee> {
	private List<Employee> employeeList = new ArrayList<>();
	private DatabaseConnection dbCon = new DatabaseConnection();
	
	@Override
	public void addRecord(Employee record) {
		record = (Employee) record;
		String sql = "Insert into employees(employee_firstname,employee_lastname,employee_post,user_id) "
				+ "VALUES(?,?,?,?)";
		try {
			dbCon.createConnection();
			PreparedStatement stm = dbCon.getConnection().prepareStatement(sql);
			stm.setString(1, record.getEmployeeFirstName());
			stm.setString(2, record.getEmployeeLastName());
			stm.setString(3, record.getEmployeePost());
			stm.setInt(4, record.getUserID());
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
		while(rs.next()) {
			Employee employee = new Employee();
			employee.setEmployeeId(rs.getInt("employee_id"));
			employee.setEmployeeFirstName(rs.getString("employee_firstname"));
			employee.setEmployeePost(rs.getString("employee_post"));
			employee.setUserID(rs.getInt("user_id"));
			employeeList.add(employee);
		}
	}
	
	@Override
	public void deleteRecord(Employee type) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateRecord(Employee type) {
		// TODO Auto-generated method stub
		
	}

}
