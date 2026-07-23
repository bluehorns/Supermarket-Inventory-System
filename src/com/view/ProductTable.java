package com.view;

import java.util.ArrayList;		
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

import com.model.Product;
import com.service.DatabaseService;
import com.service.ProductDBService;

public class ProductTable  {
	private JTable table;
	private ProductTableModel tableModel;
	
	public void intitializeTable() {
		table = new JTable();
		tableModel = new ProductTableModel();
		table.setModel(tableModel);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	}
	
	public void setTableData() {
		tableModel.setRowCount(0);
		table.setRowSorter(new TableRowSorter<ProductTableModel>(tableModel));
		DatabaseService<Product> pdi = new ProductDBService();
		List<Product> productList = new ArrayList<>();
		productList = pdi.fetchRecord();
		table.getColumnModel().getColumn(0).setMaxWidth(100); //might have to rewrite this setting columnwidth to its smallest
		for(Product prod:productList) {
			Object[] objArray = {false,prod.getId(),prod.getName(),prod.getCompany(),
					prod.getPrice(),prod.getQuantity()};
			tableModel.addRow(objArray);
			
		}
	}
	
	
	public JTable getTable() {
		return table;
	}
	
	public Product convertRowtoProduct(int row) {
		Product tempProduct  = new Product();
		tempProduct.setId((int) tableModel.getValueAt(row, 1));
		tempProduct.setName((String) tableModel.getValueAt(row, 2));
		tempProduct.setCompany((String) tableModel.getValueAt(row, 3));
		tempProduct.setPrice((int) tableModel.getValueAt(row, 4));
		tempProduct.setQuantity((int) tableModel.getValueAt(row, 5));
		return tempProduct;
	}
	
	public List<Product> getCheckBoxList() {
		List<Product> idList = new ArrayList<>(); 
		int rowCount = tableModel.getRowCount();
		for(int row=0;row<rowCount;row++) {
			if((boolean) tableModel.getValueAt(row, 0)) {
				Product tempProduct = convertRowtoProduct(row);
				idList.add(tempProduct);
			}
		}
		return idList;
		
	}
	
//	public void loopTable() {
//		int rowCount = tableModel.getRowCount();
//		for(int row=0;row<rowCount;row++) {
//			
//			
//		}
//		
//	}
}
