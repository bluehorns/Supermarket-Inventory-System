package com.view;


import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;



import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import com.service.LoginValidation;


import javax.swing.JButton;

public class LoginPage {
	private JPanel loginPanel;
	private GridBagConstraints gbc;
	private JLabel usernameLabel;
	private JTextField usernameTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordTextField;
	private JButton loginButton;
	private JButton backButton;
	private int userId;
	
	public LoginPage() {
		setUpPanel();
	}
	
	
	private void setUpPanel() {
		loginPanel = new JPanel();
		loginPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		createLoginPage();
		loginButtonEvent();
	}
	
	private void createLoginPage() {
		
		usernameLabel = new JLabel("Username:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		loginPanel.add(usernameLabel,gbc);
		
		usernameTextField = new JTextField(30);
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
		
		backButton = new JButton("Back");
		gbc.gridx = 1;
		gbc.gridy = 4;
		loginPanel.add(backButton,gbc);
	}
	
	
	public void loginButtonEvent() {
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					Boolean loginCheck;
					@Override
					protected Void doInBackground() throws Exception {
						loginCheck = loginAuthenticate();
						return null;
					}
					
					@Override
					protected void done() {
						if(loginCheck) {
							BasePage page = new BasePage(userId);
							SwingUtilities.getWindowAncestor(loginButton).dispose();
						}
						super.done();
					}
				};
				worker.execute();
				
			}
		});
	}
	
	
	public boolean loginAuthenticate() {
		String username = usernameTextField.getText();
		char[] password =  passwordTextField.getPassword();
		LoginValidation validate  = new LoginValidation();
		boolean loginCheck = validate.validateLogin(username, password);
		if(loginCheck) {
			userId = validate.getUserId();
		}
		return loginCheck;
	}
	
	public JPanel getLoginPage() {
		return loginPanel;
	}
	
	public void setBackButtonEvent(ActionListener action) {
		backButton.addActionListener(action);
	}
}
