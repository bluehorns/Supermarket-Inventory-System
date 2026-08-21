package com.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

	
public class EmployeePage {
	private JPanel employeePagePanel;
	private JScrollPane employeeTableScrollPane;
	private EmployeeTable employeeTable;
	private GridBagConstraints gbc;
	private JPanel tableHeaderPanel;
	private JPanel buttonPanel;
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	
	
	public EmployeePage() {
		intializePage();
		setUpPage();
	}
	
	private void intializePage() {
		employeePagePanel = new JPanel();
		employeePagePanel.setLayout(new GridBagLayout());
		
	}
	
	
	private void setUpPage() {
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		tableHeaderPanel = new JPanel();
		setUpTableHeaderPanel();
		gbc.weightx = 1;
		gbc.weighty = 0.3;
		gbc.gridx = 0;
		gbc.gridy = 0;
		employeePagePanel.add(tableHeaderPanel,gbc);
		
		employeeTableScrollPane = new JScrollPane();
		gbc.weightx = 1;
		gbc.weighty = 0.7;
		gbc.gridx = 0;
		gbc.gridy = 1;
		employeePagePanel.add(employeeTableScrollPane,gbc);
		
		employeeTable = new EmployeeTable();
		employeeTableScrollPane.setViewportView(employeeTable.getTable());
		
	}
	
	private void setUpTableHeaderPanel() {
		buttonPanel = new JPanel();
		tableHeaderPanel.add(buttonPanel);
		
		
		addButton = new JButton("Add");
		addButton.addActionListener(e -> {
			EmployeeForm form = new EmployeeForm("Add");
			form.backButtonEvent(a -> {
				tableHeaderPanel.remove(form.getPanel());
				tableHeaderPanel.add(buttonPanel);
				tableHeaderPanel.revalidate();
			});
			tableHeaderPanel.remove(buttonPanel);
			tableHeaderPanel.add(form.getPanel());
			tableHeaderPanel.revalidate();
		});
		buttonPanel.add(addButton);
		
		editButton = new JButton("Edit");
		buttonPanel.add(editButton);
		
		deleteButton = new JButton("Delete");
		buttonPanel.add(deleteButton);
	}
	
	
	private void employeeFormPanel() {
		JPanel form = new JPanel();
		
	}
	
	public JPanel getPage() {
		return employeePagePanel;
	}
}
