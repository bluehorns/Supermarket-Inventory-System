package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

public class EmployeeDBService implements  DatabaseService<Employee> {
	private Connection con;
	private List<Employee> employeeList = new ArrayList<>();
	
	@Override
	public void addRecord(Employee record) {
		connectToDB();
		String sql = "Insert into employees(employee_firstname,employee_lastname,employee_post,user_id) "
				+ "VALUES(?,?,?,?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, record.getEmployeeFirstName());
			stm.setString(2, record.getEmployeeLastName());
			stm.setString(3, record.getEmployeePost());
			stm.setInt(4, record.getUserID());
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
		
	}
	
	@Override
	public List<Employee> fetchRecord() {
		connectToDB();
		String sql = "Select * from employees";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			processResultSet(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
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
