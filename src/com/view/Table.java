package com.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Product;
import com.service.DatabaseService;
import com.service.ProductDBService;

public class Table {
	private JTable table;
	
	public void intitializeTable() {
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Id","Name","Company","Price","Quantity"}
				)
				);
	}
	
//	public void displayTable() {
//		table.getModel();
//	}
	
	public void setTableData() {
		DatabaseService pdi = new ProductDBService();
		List<Product> productList = new ArrayList<>();
		productList = pdi.fetchRecord();
		System.out.println(productList);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for(Product prod:productList) {
			Object[] objArray = {prod.getId(),prod.getName(),prod.getCompany(),
					prod.getPrice(),prod.getQuantity()};
			tableModel.addRow(objArray);
			
		}
	}
	
	
	public JTable getTable() {
		return table;
	}
}
