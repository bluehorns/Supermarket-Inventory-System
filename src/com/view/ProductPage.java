package com.view;

	
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

	
public class ProductPage  {
	private JPanel productPagePane;
	
	private JPanel formPanel;
	private JButton addButton;
	private JButton updateButton;
	private JButton deleteButton;
	
	private JPanel addPanel;
	private JLabel productNameLabel;
	private JTextField productNameTextField;
	private JLabel productPriceLabel;
	private JTextField productPriceTextField;
	private JLabel productQuantityLabel; //add plus/minus button
	private JTextField productQuantityTextField;
	private JLabel productCompanyLabel;
	private JTextField productCompanyTextField;
	
	private JScrollPane tableScrollPane;
	private Table productTable = new Table();
	private GridBagConstraints gbcProductPage = new GridBagConstraints();
	
	
	public ProductPage() {
		formAddPanel();
		setPanelLayout();
		//setFormPanel();
		formAddButtonEvent();
		setTableScrollPane();
	}
	
	private void setPanelLayout() {
		productPagePane = new JPanel();
		productPagePane.setLayout(new GridBagLayout());
		gbcProductPage = new GridBagConstraints();
		
		
		formPanel = new JPanel();
		formPanel.setBackground(Color.yellow);
		gbcProductPage.fill = GridBagConstraints.BOTH;
		gbcProductPage.gridx = 0;
		gbcProductPage.gridy = 0;
		gbcProductPage.weightx = 0.2;
		gbcProductPage.weighty = 1;
		productPagePane.add(addPanel,gbcProductPage);
		
		tableScrollPane = new JScrollPane();
		gbcProductPage.gridx = 1;
		gbcProductPage.weightx = 0.8;
		productPagePane.add(tableScrollPane,gbcProductPage);
			
	}	
	
	private void setFormPanel() {
		formPanel.setLayout(new BoxLayout(formPanel,BoxLayout.Y_AXIS));
		deleteButton = new JButton("Delete");
		formPanel.add(deleteButton);
		updateButton = new JButton("Update");
		formPanel.add(updateButton);
		
	}
	
	private void formAddPanel() {
		addPanel = new JPanel();
		addPanel.setLayout(new GridBagLayout());
		
		productNameLabel = new JLabel("Name:");
		gbcProductPage.gridx = 0;
		gbcProductPage.gridy = 0;
		addPanel.add(productNameLabel,gbcProductPage);
		
		productNameTextField = new JTextField(30);
		gbcProductPage.gridx = 1;
		gbcProductPage.gridy = 0;
		addPanel.add(productNameTextField,gbcProductPage);
		
		productPriceLabel = new JLabel("Price:");
		gbcProductPage.gridx = 0;
		gbcProductPage.gridy = 1;
		addPanel.add(productPriceLabel,gbcProductPage);
		
		productPriceTextField = new JTextField(30);
		gbcProductPage.gridx = 1;
		gbcProductPage.gridy = 1;
		addPanel.add(productPriceTextField,gbcProductPage);
		
		productQuantityLabel = new JLabel("Quantity:");
		gbcProductPage.gridx = 0;
		gbcProductPage.gridy = 2;
		addPanel.add(productQuantityLabel,gbcProductPage);
		
		productQuantityTextField = new JTextField(30);
		gbcProductPage.gridx = 1;
		gbcProductPage.gridy = 2;
		addPanel.add(productQuantityTextField,gbcProductPage);
		
		
		productCompanyLabel = new JLabel("Company:");
		gbcProductPage.gridx = 0;
		gbcProductPage.gridy = 3;
		addPanel.add(productCompanyLabel,gbcProductPage);
		
		productCompanyTextField = new JTextField(30);
		gbcProductPage.gridx = 1;
		gbcProductPage.gridy = 3;
		addPanel.add(productCompanyTextField,gbcProductPage);
		
		addButton = new JButton("Add");
		gbcProductPage.gridx = 1;
		gbcProductPage.gridy = 4;
		addPanel.add(addButton,gbcProductPage);
	}
	
	
	public JPanel retrievePagePane() {
		return productPagePane;
	}
	
	public void formAddButtonEvent() {
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DatabaseService pdi = new ProductDBService();	
				Product formProduct = readFormEntry();
				pdi.addRecord(formProduct);

			}
		});
	}
	
	public void formDeleteButtonEvent() {
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	public Product readFormEntry() {
		Product formProduct = new Product();
		formProduct.setName(productNameTextField.getText());
		formProduct.setPrice(Integer.parseInt(productPriceTextField.getText()));
		formProduct.setQuantity(Integer.parseInt(productQuantityTextField.getText()));
		formProduct.setCompany(productCompanyTextField.getText());
		return formProduct;
	}
	
	public void setTableScrollPane() {
		productTable.intitializeTable();
		tableScrollPane.setViewportView(productTable.getTable());
		setTableView(productTable);
	}
	
	public void setTableView(Table productTable) {
		SwingWorker<Void, Void> worker = new SwingWorker<>() {
			@Override
			protected Void doInBackground() throws Exception {
				productTable.setTableData();
				return null;
			}
		};
		
		worker.execute();
	}
}
