package com.view;



import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.model.Product;
import com.model.Sale_products;
import com.model.Sales;
import com.service.Sale_ProductDBService;
import com.service.SalesDBService;

public class BillPage {
	private JPanel billPagePanel;
	
	private JPanel headerPanel;
	private JScrollPane billScrollPane;
	private JScrollPane productTablePane;
	private JPanel billCheckoutPanel;
	private JButton checkoutButton;
	private ProductTable productTable;
	private GridBagConstraints gbc;
	
	private ProductPanel productPanel;
	private BillTable billTable;
	
	public BillPage() {
		initialisePanel();
		setUpProductTable();
		setUpHeaderPanel();
		setUpBillTable();
		setUpBillCheckoutPanel();
	}
	
	private void initialisePanel() {
	
		billPagePanel = new JPanel();
		billPagePanel.setLayout(new GridBagLayout());
		
		
		gbc = new GridBagConstraints();
		
		headerPanel = new JPanel();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		billPagePanel.add(headerPanel,gbc);
		
		productTablePane = new JScrollPane();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		billPagePanel.add(productTablePane,gbc);
		
		billScrollPane = new JScrollPane();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		billPagePanel.add(billScrollPane,gbc);
		
		
		billCheckoutPanel = new JPanel();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		billPagePanel.add(billCheckoutPanel,gbc);	
	}
	
	private void setUpBillTable() {
		billTable = new BillTable();
		billScrollPane.setViewportView(billTable.getBillTable());
	}
	
	private void setUpHeaderPanel() {
		productPanel = new ProductPanel();
		headerPanel.add(productPanel.getProductPanel());
		productPanel.addButtonEvent(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productPanel.setQuantity();
				billTable.addProduct(productPanel.getProduct());
				
			}
		});	
	}
	
	private void setUpProductTable() {
		productTable = new ProductTable();
		productTablePane.setViewportView(productTable.getTable());	
		productTable.removeColumnById(5);
		productTableListListener();
	}
	
	private void productTableListListener() {
		JTable table = productTable.getTable();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table.getSelectionModel().isSelectionEmpty()) {
					return;
				}
				if(!e.getValueIsAdjusting()) {
					int viewRow =  table.getSelectedRow();
					int modelRow = table.convertRowIndexToModel(viewRow);
					Product tempProduct = productTable.convertRowtoProduct(modelRow);
					productPanel.setProductPanel(tempProduct);
					table.getSelectionModel().clearSelection();
				}
				
			}
		});
	}
	
	private void setUpBillCheckoutPanel() {
		checkoutButton =  new JButton("Checkout");
		billCheckoutPanel.add(checkoutButton);
		checkButtonEvent();

	}
	
	private void checkButtonEvent() {
		checkoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					@Override
					protected Void doInBackground() throws Exception {
						SalesDBService salesDB = new SalesDBService();
						List<Product> billProductList = billTable.getProductList();
						Sales record = new Sales();
						record.generateSale();
						salesDB.addRecord(record);
						int saleId = salesDB.getGeneratedID();
						Sale_ProductDBService saleProductDB = new Sale_ProductDBService();
						for(Product prod:billProductList) {
							Sale_products saleProductRecord = new Sale_products();
							saleProductRecord.setSaleId(saleId);
							saleProductRecord.setSaleProduct(prod);
							saleProductDB.addRecord(saleProductRecord);
						}
						return null;
					}
				};
				worker.execute();
			}
		});
	}
	
	
	public JPanel getPage() {
		return billPagePanel;
	}
}
