package com.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.model.Sale_products;

public class SalesPage {
	private JPanel salePagePanel;
	private GridBagConstraints gbc;
	private JScrollPane saleScrollPane;
	private SaleTable saleTable;
	
	private JScrollPane saleProductScrollPane;
	private BillTable saleProductTable;
	
	
	public SalesPage() {
		intialisePanel();
		salePageSelectionEvent();
	}
	
	private void intialisePanel() {
		salePagePanel = new JPanel();
		salePagePanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();

		saleScrollPane = new JScrollPane();
		salePagePanel.add(saleScrollPane);
		saleTable = new SaleTable();
		saleScrollPane.setViewportView(saleTable.getTable());
		saleProductScrollPane = new JScrollPane();
		salePagePanel.add(saleProductScrollPane);
		setSaleProductTable();
		saleProductScrollPane.setViewportView(saleProductTable.getBillTable());
	}
	
	private void setSaleProductTable() {
		saleProductTable = new BillTable();
		
	}
	
	private void salePageSelectionEvent() {
		saleTable.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(saleTable.getTable().getSelectionModel().isSelectionEmpty()) {
					return;
				}
				if(!e.getValueIsAdjusting()) {
					saleProductTable.clearTable();
					int selectedRowView = saleTable.getTable().getSelectedRow();
					int selectedRowModel = saleTable.getTable().convertColumnIndexToModel(selectedRowView);
					int saleId = (int) saleTable.getTable().getValueAt(selectedRowModel, 0);
					List<Sale_products> saleProductList = saleTable.getSaleProductList();
					SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
						@Override
						protected Void doInBackground() throws Exception {
							List<Sale_products> filteredList = saleProductList.stream().filter((filteredProduct) -> 
							filteredProduct.getSaleId() == saleId).collect(Collectors.toList());
							for(Sale_products s:filteredList) {
								saleProductTable.addProduct(s.getSaleProduct());
							}
							return null;
						}
					};
					worker.execute();
					
					
				}
				
			}
		});
		
	}
	
	public JPanel getPage() {
		return salePagePanel;
	}
}
