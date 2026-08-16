package com.view;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.model.Product;

public class ProductPanel {
	private Product panelProduct;
	private JPanel basePanel;
	
	private JLabel productNameLabel;
	private JTextField productNameTextField;
	private JLabel companyLabel;
	private JTextField compnyTextField;
	private JSpinner quantitySpinner;
	
	private JButton addButton;
	private GridBagConstraints gbc;
	
	public ProductPanel() {
		initializePanel();
	}
	
	public void initializePanel(){
		basePanel = new JPanel();
		basePanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		productNameLabel = new JLabel("Name: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		basePanel.add(productNameLabel,gbc);
		
		productNameTextField = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 0;
		basePanel.add(productNameTextField,gbc);
		
		quantitySpinner = new JSpinner(new SpinnerNumberModel(1,1,99,1));
		gbc.gridx = 1;
		gbc.gridy = 1;
		basePanel.add(quantitySpinner,gbc);
		
		addButton = new JButton("Add");
		gbc.gridx = 1;
		gbc.gridy = 2;
		basePanel.add(addButton,gbc);
		
		
	}
	
	
	public void setProductPanel(Product product) {
		panelProduct = product;
		productNameTextField.setText(product.getName());
	}
	
	public void setQuantity() {
		panelProduct.setQuantity((int) quantitySpinner.getValue());
	}
	
	
	public Product getProduct() {
		return panelProduct;
	}
	
	public void addButtonEvent(ActionListener e) {	
		addButton.addActionListener(e);
	}
	
	public JPanel getProductPanel() {
		return basePanel;
	}
}
