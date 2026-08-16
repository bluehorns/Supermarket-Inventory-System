package com.view;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class EmployeePage {
	JPanel employeePagePanel;
	JScrollPane employeePanelScrollPane;
	EmployeeTable employeeTable;
	public EmployeePage() {
		intializePage();
	}
	
	private void intializePage() {
		employeePagePanel = new JPanel();
		employeePagePanel.setLayout(new GridBagLayout());
		
		employeePanelScrollPane = new JScrollPane();
		employeePagePanel.add(employeePanelScrollPane);
		
		employeeTable = new EmployeeTable();
		employeePanelScrollPane.setViewportView(employeeTable.getTable());
	}
	
	public JPanel getPage() {
		return employeePagePanel;
	}
}
