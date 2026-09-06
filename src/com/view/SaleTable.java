package com.view;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import com.service.DBServiceSale_Product;
import com.service.DBServiceSale;
import com.model.Sale_products;
import com.model.Sale;

public class SaleTable  {
	private JTable salesTable;
	private DefaultTableModel tableModel;
	private List<Sale> saleList = new ArrayList<>();
	private List<Sale_products> saleProductList  = new ArrayList<>();
	
	public SaleTable() {
		super();
		intialiseTable();
		fetchTableData();
		
	}
	
	private void intialiseTable() {
		salesTable = new JTable();
		tableModel = new DefaultTableModel(new Object[][] {},new String[] {"Id","Sale Date","Sale Time",
				"Employee Id"}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		salesTable.setModel(tableModel);
	}
	
	private void setTableData() {
		tableModel.setRowCount(0);
		for(Sale sale:saleList) {
			Object[] objectArray = {sale.getSalesId(),sale.getSaleDate(),sale.getSaleTime(),sale.getEmployeeId()};
			tableModel.addRow(objectArray);
		}
	}
	
	private void fetchTableData() {
		SwingWorker<Void,Void> worker = new SwingWorker<Void,Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				DBServiceSale saleDB = new DBServiceSale();
				saleList = saleDB.fetchRecord();
				DBServiceSale_Product saleProductDB = new DBServiceSale_Product();
				saleProductList = saleProductDB.fetchRecord();
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
		
	
	public JTable getTable() {
		return salesTable;
	}
	
	public List<Sale_products> getSaleProductList() {
		return saleProductList;
	}
	
	
}
