package com.view.form;


import java.awt.BorderLayout;		
import java.awt.GridLayout;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.model.DatabaseObject;
import com.model.Employee;
import com.service.DBServiceEmployee;
import com.service.DatabaseService;
import com.view.Submittable;

public class EmployeeForm extends Form  {
	
	private JPanel formPanel;
	private JPanel basePanel;
	
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel employeePostLabel;
	
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField employeePostTextField;
	
	public EmployeeForm() {
		setUpForm();
	}
	
	@Override
	public DatabaseObject getSubmitData() {
		return readForm();
	}
	
	protected void setUpForm() {
		basePanel = new JPanel();
		formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(1,6));
		basePanel.add(formPanel);
		
		firstNameLabel = new JLabel("First Name");
		formPanel.add(firstNameLabel);
		
		firstNameTextField = new JTextField(20);
		formPanel.add(firstNameTextField); 
		
		lastNameLabel = new JLabel("Last Name");
		formPanel.add(lastNameLabel);
		
		lastNameTextField = new JTextField(20);
		formPanel.add(lastNameTextField); 
		
		employeePostLabel = new JLabel("Employee Post");
		formPanel.add(employeePostLabel);
		
		employeePostTextField = new JTextField(20);
		formPanel.add(employeePostTextField); 
	};
	
	
	@Override
	public Employee readForm() {
		Employee tempEmployee = new Employee();
		tempEmployee.setEmployeeFirstName(firstNameTextField.getText());
		tempEmployee.setEmployeeLastName(lastNameTextField.getText());
		tempEmployee.setEmployeePost(employeePostTextField.getText());
		return tempEmployee;
	}
	
	@Override
	public void fillForm(DatabaseObject object) {
		
		
	}
	
	@Override
	public JPanel getPanel() {
		return basePanel;
	}
	
	
	@Override
	public DatabaseService getService() {
		return new DBServiceEmployee();
	}
}
