package com.view;


import java.awt.GridBagLayout;	
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.service.EmployeeFormService;



public class EmployeeForm {
	private JPanel formPanel;
	private JPanel addEditPanel;
	
	private JButton operationButton;
	
	private ArrayList<JTextField> textFieldList = new ArrayList<>();
	
	public EmployeeForm(String operation) {
		setUpFormPanel();
		switch(operation.toUpperCase()) {
		case "ADD":
			formPanel.add(setUpAddEditPanel());
			operationButton = new JButton(operation);
			formPanel.add(operationButton);
			//EmployeeFormService.databaseButtonEvent(operationButton);
			break;
			
		case "EDIT":
			formPanel.add(setUpAddEditPanel());
			operationButton = new JButton(operation);
			formPanel.add(operationButton);
			break;
			
		case "DELETE":
			formPanel.add(deleteOperationTable());
			operationButton = new JButton(operation);
			formPanel.add(operationButton);
			break;
			
		default:
			setUpAddEditPanel();
			break;
		}
	}
	
	private void setUpFormPanel() {
		formPanel = new JPanel();
		formPanel.setLayout(new GridBagLayout());
		//formPanel.add(backButtonSetUp());
		
	}
	
	private JPanel setUpAddEditPanel() {
		addEditPanel = new JPanel();
		addEditPanel.setLayout(new GridBagLayout());
		
		JLabel firstNameLabel = new JLabel("First Name");
		addEditPanel.add(firstNameLabel,new ModifiedGridBagConstraints().setGrid(0, 0)
				.setWeightX(0.3).setWeightY(0.5));
		
		JTextField firstNameTextField = new JTextField(20);
		addEditPanel.add(firstNameTextField,new ModifiedGridBagConstraints().setGrid(0, 1)
				.setWeightX(0.3).setWeightY(0.5)); 
		

		
		return addEditPanel;
	}
	
	private JScrollPane deleteOperationTable() {
		JScrollPane tablePane = new JScrollPane();
		HashSet<Integer> columnSet = new HashSet<>(Arrays.asList(0,1,2));
		EmployeeTable tableForDeletingEmployee = new EmployeeTable(columnSet);
		tablePane.setViewportView(tableForDeletingEmployee.getTable());
		return tablePane;
	}
	
	
	
	
	
	
	public JPanel getPanel() {
		return formPanel;
	}
}
