package com.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.service.EmployeePageService;

	
public class EmployeePage {
	private JPanel employeePagePanel;
	private JScrollPane employeeTableScrollPane;
	private EmployeeTable employeeTable;
	private GridBagConstraints gbc;
	private JPanel tableHeaderPanel;
	private JPanel buttonPanel;
	private JPanel backButtonPanel;
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton backButton;
	private JPanel operationPanel;
	private EmployeePageService service = new EmployeePageService();
	
	public EmployeePage() {
		intializePage();
		setUpPage();
		setUpTableHeaderPanel();
		setUpBackButtonPanel();
		buttonEvents();
	}
	
	private void intializePage() {
		employeePagePanel = new JPanel();
		employeePagePanel.setLayout(new GridBagLayout());
	}
	
	
	private void setUpPage() {
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		tableHeaderPanel = new JPanel();
		employeePagePanel.add(tableHeaderPanel,new ModifiedGridBagConstraints().setGrid(0, 0)
				.setWeightX(1).setWeightY(0.3).setFill());
		
		employeeTableScrollPane = new JScrollPane();
		employeePagePanel.add(employeeTableScrollPane,new ModifiedGridBagConstraints().setGrid(0, 1)
				.setWeightX(1).setWeightY(0).setFill());
		
		employeeTable = new EmployeeTable();
		employeeTableScrollPane.setViewportView(employeeTable.getTable());
	}
	
	private void setUpTableHeaderPanel() {
		tableHeaderPanel.setLayout(new GridBagLayout());
		
		backButtonPanel = new JPanel();
		tableHeaderPanel.add(backButtonPanel,new ModifiedGridBagConstraints().setGrid(0, 0)
				.setWeightX(0.1).setWeightY(1));
		
		tableHeaderPanel.add(getOperationPanel(),new ModifiedGridBagConstraints().setGrid(1, 0)
				.setWeightX(0.9).setWeightY(0.1).setFill());
	}
	
	private void setUpBackButtonPanel() {
		backButton = new JButton("Back");
		backButtonPanel.add(backButton);
		backButton.setVisible(false);
	}
	
	public JPanel getOperationPanel() {
		operationPanel = new JPanel();
		buttonPanel = new JPanel();
		operationPanel.add(buttonPanel);
		
		addButton = new JButton("Add");
		buttonPanel.add(addButton);
		
		editButton = new JButton("Edit");
		buttonPanel.add(editButton);
		
		deleteButton = new JButton("Delete");
		
		buttonPanel.add(deleteButton);
		return operationPanel;
	}
	
	
	private void buttonEvents() {
		EmployeePageService.operationButtonEvent(addButton, backButton, operationPanel);
		EmployeePageService.operationButtonEvent(editButton, backButton, operationPanel);
		EmployeePageService.operationButtonEvent(deleteButton, backButton, operationPanel);
		EmployeePageService.backButtonEvent(backButton, operationPanel, buttonPanel);
	}
	
	
	public JPanel getPage() {
		return employeePagePanel;
	}
}
