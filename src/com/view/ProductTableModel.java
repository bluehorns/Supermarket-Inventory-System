package com.view;

import javax.swing.table.DefaultTableModel;

public class ProductTableModel extends DefaultTableModel {
	
	public ProductTableModel() {
		super(
			new Object[][] {},
			new String[] {"","Id","Name","Company","Price","Quantity"});
	}
	
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?> colClass = Object.class;
		switch (columnIndex) {
		case 0: {
			colClass = Boolean.class;
			break;
		}
		case 1: {
			colClass = Integer.class;
			break;
		}
		default:
			colClass = Object.class;
			break;
		}
		return colClass;
		
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
//		Boolean boolCellEditable = false;
//		if(column == 0) {
//			boolCellEditable = true;
//		}
//		return boolCellEditable;
		return false;
	}
}
