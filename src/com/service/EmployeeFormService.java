package com.service;





import javax.swing.JButton;
import javax.swing.JPanel;
import com.model.Employee;


public class EmployeeFormService {
	
	public static void databaseButtonEvent(JButton button, Employee employee) {
		button.addActionListener(_ -> {
			EmployeeDBService dbService = new EmployeeDBService();
			dbService.addRecord(employee);
		}
		);
		
	}
	
	public static void readForm(JPanel formPanel) {
		
		Employee employee = new Employee();
		
	}
}
