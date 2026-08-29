package com.view;


import java.awt.BorderLayout;	
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.HashSet;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.model.Employee;




public class EmployeeForm {
	private JPanel formPanel;
	private JPanel addEditGridPanel;
	
	private JLabel firstNameLabel;
	private JTextField firstNameTextField;
	private JLabel lastNameLabel;
	private JTextField lastNameTextField;
	private JLabel employeePostLabel;
	private JTextField employeePostTextField;
	
	public EmployeeForm() {
		setUpFormPanel();
		setOperationPanel();
	}
	
	public void setOperationPanel() {
		formPanel.add(setUpAddEditGridPanel(),BorderLayout.CENTER);
		formPanel.revalidate();
	}
	
	private void setUpFormPanel() {
		formPanel = new JPanel();
		formPanel.setLayout(new BorderLayout());
	}
	
	private JPanel setUpAddEditGridPanel() {
		addEditGridPanel = new JPanel();
		addEditGridPanel.add(setUpAddEditFormPanel());
		return addEditGridPanel;
	}
	
	private JPanel setUpAddEditFormPanel() {
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
		
		return formPanel;
	};
	
	public Employee readForm() {
		Employee tempEmployee = new Employee();
		tempEmployee.setEmployeeFirstName(firstNameTextField.getText());
		tempEmployee.setEmployeeLastName(lastNameTextField.getText());
		tempEmployee.setEmployeePost(employeePostTextField.getText());
		return tempEmployee;
	}
	
	public JPanel getPanel() {
		return formPanel;
	}
}
