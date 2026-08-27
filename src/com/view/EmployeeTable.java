package com.view;

import java.awt.Dimension;
import java.util.ArrayList;	
import java.util.List;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import com.model.Employee;
import com.service.DatabaseService;
import com.service.EmployeeDBService;

public class EmployeeTable {
	private JTable employeeTable;
	private DefaultTableModel tableModel;
	private List<Employee> employeeList = new ArrayList<>();
	private final int columnCount = 5;
	
	public EmployeeTable() {
		intializeTable();
		fetchTableData();
	}
	
	
	public EmployeeTable(Set<Integer> columnSet) {
		intializeTable();
		fetchTableData();
		deleteColumnBasedOnArray(columnSet);
	}
	
	public void deleteColumnBasedOnArray(Set<Integer> columnSet) {
		for(int i=columnCount-1;i>=0;i--) {
			if(!columnSet.contains(i)) {
				employeeTable.getColumnModel().removeColumn(employeeTable.getColumnModel().getColumn(i));
			}
		}
	}
	
	private void intializeTable() {
		employeeTable = new JTable();
		tableModel = new DefaultTableModel(new Object[][] {}, new String[] {"S.N","Employee ID","First Name",
				"Last Name","Post"}) {
			
		};
		employeeTable.setModel(tableModel);
		employeeTable.setPreferredScrollableViewportSize(new Dimension(0,0));
 
	}
	
	private void fetchTableData() {
		SwingWorker<Void, Void> worker = new SwingWorker<>() {
			@Override
			protected Void doInBackground() throws Exception {
				DatabaseService<Employee> dbService = new EmployeeDBService();
				employeeList = dbService.fetchRecord();
				return null;
			}
			
			@Override
			protected void done() {
				setTableData();
				super.done();
			}
		};
		worker.execute();
	}
	
	private void setTableData() {
		int i = 1;
		for(Employee employee:employeeList) {
			Object[] newRow = {i,employee.getEmployeeId(),employee.getEmployeeFirstName(),
					employee.getEmployeeLastName(),employee.getEmployeePost()};
			tableModel.addRow(newRow);
			i++;
		}
	}
	
	public JTable getTable() {
		return employeeTable;
	}
}
