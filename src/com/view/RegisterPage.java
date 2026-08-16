package com.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RegisterPage {
	private JPanel registerPagePanel;
	private JButton backButton;
	
	public RegisterPage() {
		setUpPanel();
	}
	
	private void setUpPanel() {
		registerPagePanel = new JPanel();
	}
	
	public JPanel getRegisterPage() {
		return registerPagePanel;
	}
	
	public void setBackButton(ActionListener listener) {
		backButton.addActionListener(listener);
	}
}
