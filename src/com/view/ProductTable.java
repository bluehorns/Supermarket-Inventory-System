package com.view;

import java.util.ArrayList;		
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.model.Product;
import com.service.DatabaseService;
import com.service.ProductDBService;

public class ProductTable  {
	private JTable table;
	private DefaultTableModel tableModel;
	
	public ProductTable() {
		initializeTable();
		setTableData();
	}
	
	
	private void initializeTable() {
		table = new JTable();
		tableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Id","Name","Company","Price","Stock/Quantity",""}) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				Class<?> colClass = Object.class;
				switch (columnIndex) {
				case 5: {
					colClass = Boolean.class;
					break;
				}
				case 0: {
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
				return false;
			}
		};
		table.setModel(tableModel);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(tableModel));
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public void setTableData() {
		SwingWorker<Void, Void> worker = new SwingWorker<>() {
			@Override
			protected Void doInBackground() throws Exception {
				tableModel.setRowCount(0);
				
				DatabaseService<Product> pdi = new ProductDBService();
				List<Product> productList = new ArrayList<>();
				productList = pdi.fetchRecord();
				table.getColumnModel().getColumn(0).setMaxWidth(100); //might have to rewrite this setting columnwidth to its smallest
				for(Product prod:productList) {
					Object[] objArray = {prod.getId(),prod.getName(),prod.getCompany(),
							prod.getPrice(),prod.getQuantity(),false};
					tableModel.addRow(objArray);
					
				}
				return null;
			}
			
			@Override
			protected void done() {
				// TODO Auto-generated method stub
				super.done();
			}
			
		};
		worker.execute();
	}
	
	
	public JTable getTable() {
		return table;
	}
	
	public Product convertRowtoProduct(int row) {
		Product tempProduct  = new Product();
		tempProduct.setId((int) tableModel.getValueAt(row, 0));
		tempProduct.setName((String) tableModel.getValueAt(row, 1));
		tempProduct.setCompany((String) tableModel.getValueAt(row, 2));
		tempProduct.setPrice((int) tableModel.getValueAt(row, 3));
		tempProduct.setQuantity((int) tableModel.getValueAt(row, 4));
		return tempProduct;
	}
	
	public List<Product> getCheckBoxList() {
		List<Product> idList = new ArrayList<>(); 
		int rowCount = tableModel.getRowCount();
		for(int row=0;row<rowCount;row++) {
			if((boolean) tableModel.getValueAt(row, 5)) {
				Product tempProduct = convertRowtoProduct(row);
				idList.add(tempProduct);
			}
		}
		return idList;
		
	}
	
	public void removeColumnById(int columnId) {
		table.removeColumn(table.getColumnModel().getColumn(columnId));
		table.repaint();
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
