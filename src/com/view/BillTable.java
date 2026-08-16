package com.view;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Product;


public class BillTable {
	private JTable billTable;
	private DefaultTableModel billTableModel;
	private List<Product> billList;
	
	public BillTable() {
		intializeTable();
		billList = new ArrayList<Product>();
	}
	
	private void intializeTable() {
		billTableModel = new DefaultTableModel(new Object[][] {}, new String[] {"","S.N","Name","Price","Quantity","Total"});
		billTable = new JTable(billTableModel);
		
	}
	
	public void addProduct(Product prod) {
		Object[] objArray = {"",prod.getId(),prod.getName(),prod.getPrice(),prod.getQuantity(),
				prod.getPrice()*prod.getQuantity()};
		billTableModel.addRow(objArray);
		billTable.repaint();
		billList.add(prod);
	}
	
	public JTable getBillTable() {
		return billTable;
	}
	
	public List<Product> getProductList() {
		return billList;
	}
	
	public void clearTable() {
		billTableModel.setRowCount(0);
		billTable.repaint();
	}
}
