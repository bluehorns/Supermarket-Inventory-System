package com.view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmployeeTable {
	private JTable employeeTable;
	private DefaultTableModel tableModel;
	
	public EmployeeTable() {
		intializeTable();
	}
	
	private void intializeTable() {
		employeeTable = new JTable();
		tableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Employee ID","Name","Post"}) {
			
		};
		employeeTable.setModel(tableModel);
	}
	
	public JTable getTable() {
		return employeeTable;
	}
}
