package com.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmployeeForm {
	private JPanel formPanel;
	private JButton backButton;
	private JPanel backButtonPanel;
	private JLabel firstNameLabel;
	private JTextField firstNameTextField;
	
	public EmployeeForm(String operation) {
		setUpPanel();
	}
	
	private void addEmployeeForm() {
		
	}
	
	private void setUpPanel() {
		formPanel = new JPanel();
		formPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.1;
		gbc.weighty = 1;
		formPanel.add(backButtonSetUp(),gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.3;
		gbc.weighty = 0.5;
		gbc.gridheight = 1;
		formPanel.add(formPanel("First Name"),gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.3;
		gbc.weighty = 0.5;
		gbc.gridheight = 1;
		formPanel.add(formPanel("Last Name"),gbc); 
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 0.3;
		gbc.weighty = 0.5;
		gbc.gridheight = 1;
		formPanel.add(formPanel("Post"),gbc);	
	}
	
	private void deleteEmployeeTable() {
		
	}
	
	private JButton backButtonSetUp() {
		backButton = new JButton("Back");
		backButton.setIcon(UserInterfaceIcons.backIconBlack());
		return backButton;
	}
	
	public void backButtonEvent(ActionListener listener) {
		backButton.addActionListener(listener);
	}
	
	private JPanel formPanel(String formComponent) {
		JPanel panel = new JPanel();
		JLabel componentLabel = new JLabel(formComponent + ":");
		panel.add(componentLabel);
		
		JTextField componentTextField = new JTextField(20);
		panel.add(componentTextField);
		
		return panel;
	}
	
	public JPanel getPanel() {
		return formPanel;
	}
}
