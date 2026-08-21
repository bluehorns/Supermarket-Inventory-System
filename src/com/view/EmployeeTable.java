package com.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	private HashMap<String,Object> employeeTableMap = new HashMap<>();
	public EmployeeTable() {
		intializeTable();
		fetchTableData();
	}
	
	private void setHashMap() {
		employeeTableMap.put("S.N", null);
		employeeTableMap.put("Employee ID", employeeList);
	}
	
	public EmployeeTable(String[] columns) {
		employeeTable = new JTable();
		tableModel = new DefaultTableModel(new Object[][] {},columns);
		employeeTable.setModel(tableModel);
	}
	
	private void intializeTable() {
		employeeTable = new JTable();
		tableModel = new DefaultTableModel(new Object[][] {}, new String[] {"S.N","Employee ID","First Name",
				"Last Name","Post"}) {
			
		};
		employeeTable.setModel(tableModel);
	}
	
	private void createAndSetTableModel() {
		
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
			int columnCount = tableModel.getColumnCount();
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
