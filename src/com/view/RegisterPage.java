package com.view;

import java.awt.Dimension;	
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import com.model.User_Info;
import com.service.Registration;


public class RegisterPage {
	private JPanel registerPagePanel;
	private JButton submitButton;
	
	private GridBagConstraints gbc;
	private JLabel firstNameLabel;
	private JTextField firstNameTextField;
	private JLabel lastNameLabel;
	private JTextField lastNameTextField;
	private JLabel userNameLabel;
	private JTextField userNameTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordTextField;
	
	public RegisterPage() {
		setUpPanel();
		setUpForm();
		submitButtonEvent();
	}
	
	private void setUpPanel() {
		registerPagePanel = new JPanel();
		registerPagePanel.setPreferredSize(new Dimension(300,300));
		registerPagePanel.setLayout(new GridBagLayout());
	}
	private void setUpForm() {
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		firstNameLabel = new JLabel("First Name:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		registerPagePanel.add(firstNameLabel,gbc);
		
		firstNameTextField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		registerPagePanel.add(firstNameTextField,gbc);
		
		lastNameLabel = new JLabel("Last Name:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		registerPagePanel.add(lastNameLabel,gbc);
		
		lastNameTextField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 1;
		registerPagePanel.add(lastNameTextField,gbc);
		
		userNameLabel = new JLabel("Username:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		registerPagePanel.add(userNameLabel,gbc);
		
		userNameTextField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 2;
		registerPagePanel.add(userNameTextField,gbc);
		
		passwordLabel = new JLabel("Password:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		registerPagePanel.add(passwordLabel,gbc);
		
		passwordTextField = new JPasswordField(20);
		gbc.gridx = 1;
		gbc.gridy = 3;
		registerPagePanel.add(passwordTextField,gbc);
		
		submitButton = new JButton("Submit");
		gbc.gridx = 1;
		gbc.gridy = 4;
		registerPagePanel.add(submitButton,gbc);
		
	}
	
	
	private void submitButtonEvent() {
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				submitButton.addActionListener(e ->{
					Registration registerProcess = new Registration();
					registerProcess.registerUserInfo(createUserInfo());
					registerProcess.registerUserAccount(userNameTextField.getText(), 
							passwordTextField.getPassword());
				});
				return null;
			}
			
			@Override
			protected void done() {
				// TODO Auto-generated method stub
				super.done();
			}
		};
		worker.execute();
	}
	
	private User_Info createUserInfo() {
		User_Info info = new User_Info();
		info.setUserFirstName(firstNameTextField.getText());
		info.setUserLastName(lastNameTextField.getText());
		info.setUserType("Customer");
		return info;
	}
	
	public JPanel getRegisterPage() {
		return registerPagePanel;
	}
	

}
