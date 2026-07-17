package com.view;


import java.awt.GridBagLayout;		
import java.awt.GridBagConstraints;



import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.JButton;

public class LoginPage {
	private JPanel loginPanel;
	private GridBagConstraints gbc;
	private JLabel usernameLabel;
	private JTextField usernameTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordTextField;
	private JButton loginButton;
	private JButton registerButton;
	
	public LoginPage() {
		
		setUpPanel();
	}
	
	
	private void setUpPanel() {
		loginPanel = new JPanel();
		loginPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		createLoginPage();
		
	}
	
	private void createLoginPage() {
		
		usernameLabel = new JLabel("Username:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		loginPanel.add(usernameLabel,gbc);
		
		usernameTextField = new JTextField("Enter username",30);
		gbc.gridx = 1;
		gbc.gridy = 0;
		loginPanel.add(usernameTextField,gbc);
		
		passwordLabel = new JLabel("Password");
		gbc.gridx = 0;
		gbc.gridy = 1;
		loginPanel.add(passwordLabel,gbc);
		
		passwordTextField = new JPasswordField(30);
		gbc.gridx = 1;
		gbc.gridy = 1;
		loginPanel.add(passwordTextField,gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		JLabel blankLabel = new JLabel(" "); //create an empty row for gridbaglayout
		loginPanel.add(blankLabel,gbc);
		
		loginButton = new JButton("Login");
		gbc.gridx = 1;
		gbc.gridy = 3;
		loginPanel.add(loginButton,gbc);
		
		
	}
	
	private void loginAuthentication() {
		
	}
	
	public JPanel retrieveLoginPage() {
		return loginPanel;
	}
}
