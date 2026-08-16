package com.view;

	
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import com.model.Product;
import com.service.DatabaseService;
import com.service.ProductDBService;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

	
public class ProductPage  {
	private JPanel productPagePane;
	
	private JButton deleteButton;
	private JButton refreshButton;
	
	private ProductFormPanel formPanel;
	
	private JPanel tableHeaderPanel;
	private JScrollPane tableScrollPane;
	private ProductTable productTable;
	private GridBagConstraints gbcProductPage = new GridBagConstraints();
	
	
	public ProductPage() {
		setPanelLayout();
		addButtonEvent();
		updateButtonEvent();
		setTableScrollPane();
		setUptableHeaderPanel();
		rowListener();
	}
	
	private void setPanelLayout() {
		productPagePane = new JPanel();
		productPagePane.setLayout(new GridBagLayout());
		gbcProductPage = new GridBagConstraints();
		
		formPanel = new ProductFormPanel();
		gbcProductPage.fill = GridBagConstraints.BOTH;
		gbcProductPage.gridx = 0;
		gbcProductPage.gridy = 0;
		gbcProductPage.weightx = 0.1;
		gbcProductPage.weighty = 1;
		gbcProductPage.gridheight = 2;
		productPagePane.add(formPanel.getPanel(),gbcProductPage);
		
		
		tableHeaderPanel = new JPanel();
		gbcProductPage.gridx = 1;
		gbcProductPage.gridy = 0;
		gbcProductPage.gridheight = 1;
		gbcProductPage.weightx = 0.8;
		gbcProductPage.weighty = 0.1;
		productPagePane.add(tableHeaderPanel,gbcProductPage);
		tableHeaderPanel.setBackground(Color.yellow);
		
		tableScrollPane = new JScrollPane();
		gbcProductPage.gridx = 1;
		gbcProductPage.gridy = 1;
		gbcProductPage.weightx = 0.8;
		gbcProductPage.weighty = 0.9;
		productPagePane.add(tableScrollPane,gbcProductPage);
			
	}	
	
	private void setUptableHeaderPanel() {
		refreshButton = new JButton("Refresh");
		tableHeaderPanel.add(refreshButton);
		refreshButtonEvent();
		
		deleteButton = new JButton("Delete");
		tableHeaderPanel.add(deleteButton);
		deleteButtonEvent();
	}
	
	
	public JPanel retrievePagePane() {
		return productPagePane;
	}
	
	
	private void refreshButtonEvent() {
		refreshButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productTable.setTableData();
			}
		});
	}
	
	private void addButtonEvent() {
		JButton addButton = formPanel.getAddButton();
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DatabaseService<Product> pdi = new ProductDBService();	
				Product formProduct = formPanel.readFormEntry();
				SwingWorker<Void,Void> worker = new SwingWorker<Void,Void>() {
					@Override
					protected Void doInBackground() throws Exception {
						pdi.addRecord(formProduct);
						return null;
					}
				};
				worker.execute();

			}
		});
	
	}
	
	private void deleteButtonEvent() {
		deleteButton.addActionListener(new ActionListener() {
			List<Product> productList = new ArrayList<>();
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
					@Override
					protected Void doInBackground() throws Exception {
						DatabaseService<Product> pdi = new ProductDBService();
						productList = productTable.getCheckBoxList();
						for(Product prod:productList) {
							pdi.deleteRecord(prod);
						}
						return null;
					}
				};	
				worker.execute();	
			}
		});
	}
	
	private void updateButtonEvent() {
		JButton updateButton = formPanel.getUpdateButton();
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
					@Override
					protected Void doInBackground() throws Exception {
						DatabaseService<Product> pdi = new ProductDBService();
						Product formProduct = formPanel.readFormEntry();
						pdi.updateRecord(formProduct);
						return null;
					}
					
					
				};
				worker.execute();	
			}
		});
	}
	
	private void rowListener() {
		JTable table = productTable.getTable();
		TableModel tableModel = table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table.getSelectionModel().isSelectionEmpty()) {
					return;
				}
				//maybe add a way to drag select multiple rows
				if(!e.getValueIsAdjusting()) {
					int viewRow =  table.getSelectedRow();
					int modelRow = table.convertRowIndexToModel(viewRow);
					Boolean checkbox = (Boolean) tableModel.getValueAt(modelRow, 5);
					tableModel.setValueAt(!checkbox, modelRow, 5);
					Product tempProduct = productTable.convertRowtoProduct(modelRow);
					formPanel.fillFormWithSelection(tempProduct);
					table.getSelectionModel().clearSelection();
				}
			}
		});
	
	}
	
	private void setTableScrollPane() {
		productTable = new ProductTable();
		tableScrollPane.setViewportView(productTable.getTable());
	}
	
}
