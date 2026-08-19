package com.view;

import java.util.ArrayList;
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
	public EmployeeTable() {
		intializeTable();
		fetchTableData();
	}
	
	private void intializeTable() {
		employeeTable = new JTable();
		tableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Employee ID","Name","Post"}) {
			
		};
		employeeTable.setModel(tableModel);
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
		for(Employee employee:employeeList) {
			Object[] newRow = {employee.getEmployeeId(),employee.getEmployeeName(),employee.getEmployeePost()};
			tableModel.addRow(newRow);
		}
	}
	public JTable getTable() {
		return employeeTable;
	}
}
