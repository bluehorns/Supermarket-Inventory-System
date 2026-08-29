package com.view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.service.EmployeePageService;

	
public class EmployeePage {
	private JPanel employeePagePanel;
	private JScrollPane employeeTableScrollPane;
	private EmployeeForm employeeForm;
	private EmployeeTable employeeTable;
	private JPanel tableHeaderPanel;
	private JPanel buttonPanel;
	private JPanel backButtonPanel;
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton backButton;
	private JPanel operationPanel;
	private JButton operationButton;
	private JPanel operationButtonPanel;
	
	
	public EmployeePage() {
		intializePage();
		setUpPage();
		setUpTableHeaderPanel();
//		setUpBackButtonPanel();
//		setUpOperationButtonPanel();
//		buttonEvents();
	}
	
	private void intializePage() {
		employeePagePanel = new JPanel();
		employeePagePanel.setLayout(new GridBagLayout());
	}
	
	
	private void setUpPage() {
		tableHeaderPanel = new JPanel();
		employeePagePanel.add(tableHeaderPanel,new GBC().setGrid(0, 0).setWeightX(1)
				.setWeightY(0.1).setFill(GBC.BOTH));
		
		employeeTableScrollPane = new JScrollPane();
		employeePagePanel.add(employeeTableScrollPane,new GBC().setGrid(0, 1).setWeightX(1)
				.setWeightY(0.9).setFill(GBC.BOTH));
		
		employeeTable = new EmployeeTable();
		employeeTableScrollPane.setViewportView(employeeTable.getTable());
		
	}
	
	private void setUpTableHeaderPanel() {
		tableHeaderPanel.setLayout(new BorderLayout());
		tableHeaderPanel.add(new CRUDPanel());
//		backButtonPanel = new JPanel();
//		tableHeaderPanel.add(backButtonPanel,BorderLayout.WEST);
//		
//		tableHeaderPanel.add(getOperationPanel(),BorderLayout.CENTER);
//		
//		employeeForm = new EmployeeForm();
//		operationButtonPanel = new JPanel();
//		tableHeaderPanel.add(operationButtonPanel,BorderLayout.EAST);
	}
	
	private void setUpBackButtonPanel() {
		backButton = new JButton("Back");
		backButtonPanel.add(backButton);
		backButton.setVisible(false);
		
//		JButton sizeButton = new JButton("Size");
//		sizeButton.addActionListener(_->{
//			System.out.println(employeeTableScrollPane.getSize());
//		});
//		backButtonPanel.add(sizeButton);
	}
	
	private void setUpOperationButtonPanel() {
		operationButton = new JButton("Submit");
		operationButtonPanel.add(operationButton);
	}
	
	public JPanel getOperationPanel() {
		operationPanel = new JPanel();
		operationPanel.setLayout(new BorderLayout());
		buttonPanel = new JPanel();
		operationPanel.add(buttonPanel,BorderLayout.CENTER);
		
		addButton = new JButton("Add");
		buttonPanel.add(addButton);
		
		editButton = new JButton("Edit");
		buttonPanel.add(editButton);
		
		deleteButton = new JButton("Delete");
		buttonPanel.add(deleteButton);
		
		return operationPanel;
	}
	
	
	private void buttonEvents() {
		EmployeePageService.selectOperationButtonEvent(employeeForm,addButton, backButton, operationPanel);
		EmployeePageService.selectOperationButtonEvent(employeeForm,editButton, backButton, operationPanel);
		EmployeePageService.selectOperationButtonEvent(employeeForm,deleteButton, backButton, operationPanel);
		EmployeePageService.backButtonEvent(backButton, operationPanel, buttonPanel);
		EmployeePageService.submitFormButtonEvent(operationButton, employeeForm);
	}
	
	
	public JPanel getPage() {
		return employeePagePanel;
	}
}
