package com.view.form;


import java.awt.BorderLayout;	
import java.awt.GridLayout;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.model.DatabaseObject;
import com.model.Employee;
import com.service.ReadForm;
import com.view.Submittable;

public class EmployeeForm extends Form implements Submittable {
	
	private JPanel formPanel;
	private JPanel addEditGridPanel;
	
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
	
//	private JPanel setUpAddEditGridPanel() {
//		addEditGridPanel = new JPanel();
//		addEditGridPanel.add(setUpAddEditFormPanel());
//		return addEditGridPanel;
//	}
//	
	protected void setUpForm() {
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(1,6));
		
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
	public DatabaseObject readForm() {
		Employee tempEmployee = new Employee();
		tempEmployee.setEmployeeFirstName(firstNameTextField.getText());
		tempEmployee.setEmployeeLastName(lastNameTextField.getText());
		tempEmployee.setEmployeePost(employeePostTextField.getText());
		return tempEmployee;
	}
	
	@Override
	public void fillForm(DatabaseObject object) {
		
		
	}
	
	public JPanel getPanel() {
		return formPanel;
	}
}
