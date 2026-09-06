package com.view.form;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.model.DatabaseObject;
import com.model.Product;


public class ProductForm extends Form {
	private JPanel productFormPanel;
	private JPanel formPanel;
	
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
	
	
	public ProductForm() {
		setUpForm();
	}
	
	@Override
	protected void setUpForm() {
		formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(6,2));
		
		//Row1
		productIdLabel = new JLabel("ID:");
		formPanel.add(productIdLabel);
		
		productIdTextField = new JTextField();
		productIdTextField.setEditable(false);
		formPanel.add(productIdTextField);
		
		//Row2
		productNameLabel = new JLabel("Name:");
		formPanel.add(productNameLabel);
		
		productNameTextField = new JTextField();
		productNameTextField.setEditable(false);
		formPanel.add(productNameTextField);
		
		//Row 3
		productPriceLabel = new JLabel("Price:");
		formPanel.add(productPriceLabel);
		
		productPriceTextField = new JTextField();
		formPanel.add(productPriceTextField);
		
		//Row 4
		productQuantityLabel = new JLabel("Quantity:");
		formPanel.add(productQuantityLabel);
		
		productQuantityTextField = new JTextField();
		formPanel.add(productQuantityTextField);
		
		//Row 5
		
		productCompanyLabel = new JLabel("Company:");
		formPanel.add(productCompanyLabel);
		
		productCompanyTextField = new JTextField();
		formPanel.add(productCompanyTextField);
		
	}
	
	
//	private void intialisePanel() {
//		productFormPanel = new JPanel();
//		productFormPanel.setLayout(new GridBagLayout());
//		gbc = new GridBagConstraints();
//		
//		productIdLabel = new JLabel("ID:");
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		productFormPanel.add(productIdLabel,gbc);
//		
//		productIdTextField = new JTextField(30);
//		productIdTextField.setEditable(false);
//		gbc.gridx = 1;
//		gbc.gridy = 0;
//		productFormPanel.add(productIdTextField,gbc);
//		
//		productNameLabel = new JLabel("Name:");
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		productFormPanel.add(productNameLabel,gbc);
//		
//		productNameTextField = new JTextField(30);
//		gbc.gridx = 1;
//		gbc.gridy = 1;
//		productFormPanel.add(productNameTextField,gbc);
//		
//		productPriceLabel = new JLabel("Price:");
//		gbc.gridx = 0;
//		gbc.gridy = 2;
//		productFormPanel.add(productPriceLabel,gbc);
//		
//		productPriceTextField = new JTextField(30);
//		gbc.gridx = 1;
//		gbc.gridy = 2;
//		productFormPanel.add(productPriceTextField,gbc);
//		
//		productQuantityLabel = new JLabel("Quantity:");
//		gbc.gridx = 0;
//		gbc.gridy = 3;
//		productFormPanel.add(productQuantityLabel,gbc);
//		
//		productQuantityTextField = new JTextField(30);
//		gbc.gridx = 1;
//		gbc.gridy = 3;
//		productFormPanel.add(productQuantityTextField,gbc);
//		
//		
//		productCompanyLabel = new JLabel("Company:");
//		gbc.gridx = 0;
//		gbc.gridy = 4;
//		productFormPanel.add(productCompanyLabel,gbc);
//		
//		productCompanyTextField = new JTextField(30);
//		gbc.gridx = 1;
//		gbc.gridy = 4;
//		productFormPanel.add(productCompanyTextField,gbc);
//		
//	}
	@Override
	public DatabaseObject readForm() {
		Product formProduct = new Product();
		if(!productIdTextField.getText().equals("")) {
			formProduct.setId(Integer.parseInt(productIdTextField.getText()));
		}
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
	
	
	@Override
	public void fillForm(DatabaseObject object) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public JPanel getPanel() {
		return formPanel;
	}
	
}
