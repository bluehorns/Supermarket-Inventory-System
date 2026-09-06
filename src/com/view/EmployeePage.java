package com.view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.view.form.EmployeeForm;

	
public class EmployeePage {
	private JPanel employeePagePanel;
	private JPanel tableHeaderPanel;
	
	private JScrollPane employeeTableScrollPane;
	private EmployeeTable employeeTable;
	
	private CRUDPanel crudPanel;
	private EmployeeForm employeeForm;
	
	public EmployeePage() {
		intializePageBasePanel();
		setUpPage();
		setUpTableHeaderPanel();
	}
	
	private void intializePageBasePanel() {
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
		crudPanel = new CRUDPanel();
		employeeForm = new EmployeeForm();
		crudPanel.addButtonPanel(employeeForm.getPanel());
		tableHeaderPanel.add(crudPanel);
	}
	
	
	public JPanel getPage() {
		return employeePagePanel;
	}
}
