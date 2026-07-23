package com.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.model.Product;
import com.service.DatabaseService;
import com.service.ProductDBService;

public class ProductFormPanel {
	private JPanel productFormPanel;
	private JPanel formPanel;
	private JButton addButton;
	private JButton updateButton;
	
	private JLabel productIdLabel;
	private JTextField productIdTextField;
	private JLabel productNameLabel;
	private JTextField productNameTextField;
	private JLabel productPriceLabel;
	private JTextField productPriceTextField;
	private JLabel productQuantityLabel; //add plus/minus button
	private JTextField productQuantityTextField;
	private JLabel productCompanyLabel;
	private JTextField productCompanyTextField;
	
	private GridBagConstraints gbc;
	
	public ProductFormPanel() {
		intialisePanel();
	}
	
	private void intialisePanel() {
		productFormPanel = new JPanel();
		productFormPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		productIdLabel = new JLabel("ID:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		productFormPanel.add(productIdLabel,gbc);
		
		productIdTextField = new JTextField(30);
		productIdTextField.setEditable(false);
		gbc.gridx = 1;
		gbc.gridy = 0;
		productFormPanel.add(productIdTextField,gbc);
		
		productNameLabel = new JLabel("Name:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		productFormPanel.add(productNameLabel,gbc);
		
		productNameTextField = new JTextField(30);
		gbc.gridx = 1;
		gbc.gridy = 1;
		productFormPanel.add(productNameTextField,gbc);
		
		productPriceLabel = new JLabel("Price:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		productFormPanel.add(productPriceLabel,gbc);
		
		productPriceTextField = new JTextField(30);
		gbc.gridx = 1;
		gbc.gridy = 2;
		productFormPanel.add(productPriceTextField,gbc);
		
		productQuantityLabel = new JLabel("Quantity:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		productFormPanel.add(productQuantityLabel,gbc);
		
		productQuantityTextField = new JTextField(30);
		gbc.gridx = 1;
		gbc.gridy = 3;
		productFormPanel.add(productQuantityTextField,gbc);
		
		
		productCompanyLabel = new JLabel("Company:");
		gbc.gridx = 0;
		gbc.gridy = 4;
		productFormPanel.add(productCompanyLabel,gbc);
		
		productCompanyTextField = new JTextField(30);
		gbc.gridx = 1;
		gbc.gridy = 4;
		productFormPanel.add(productCompanyTextField,gbc);
		
		addButton = new JButton("Add");
		gbc.gridx = 1;
		gbc.gridy = 5;
		productFormPanel.add(addButton,gbc);
		
		updateButton = new JButton("Update");
		gbc.gridx = 1;
		gbc.gridy = 6;
		productFormPanel.add(updateButton,gbc);
	}
	
	public Product readFormEntry() {
		Product formProduct = new Product();
		formProduct.setId(Integer.parseInt(productIdTextField.getText()));
		formProduct.setName(productNameTextField.getText());
		formProduct.setPrice(Integer.parseInt(productPriceTextField.getText()));
		formProduct.setQuantity(Integer.parseInt(productQuantityTextField.getText()));
		formProduct.setCompany(productCompanyTextField.getText());
		return formProduct;
	}
	
	public void fillFormWithSelection(Product selectedProduct) {
		productIdTextField.setText(String.valueOf(selectedProduct.getId()));
		productNameTextField.setText(selectedProduct.getName());
		productPriceTextField.setText(String.valueOf(selectedProduct.getPrice()));
		productQuantityTextField.setText(String.valueOf(selectedProduct.getQuantity()));
		productCompanyTextField.setText(selectedProduct.getCompany());
		
	}
	
	public JPanel getPanel() {
		return productFormPanel;
	}
	
	public JButton getAddButton() {
		return addButton;
	}
	
	public JButton getUpdateButton() {
		return updateButton;
	}
}
