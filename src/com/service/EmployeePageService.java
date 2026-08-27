package com.service;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.view.EmployeeForm;

public class EmployeePageService {
	
	public static void operationButtonEvent(JButton button,JButton backButton, JPanel operationPanel) {
		button.addActionListener(_ ->{
			backButton.setVisible(true);
			operationPanel.removeAll();
			operationPanel.add(new EmployeeForm(button.getText()).getPanel(),BorderLayout.CENTER);
			operationPanel.revalidate();
		});
		//return operation;
	}
	
	public static void backButtonEvent(JButton button,JPanel operationPanel, JPanel buttonPanel) {
		button.addActionListener(_ ->{
			button.setVisible(false);
			operationPanel.removeAll();
			operationPanel.add(buttonPanel);
			operationPanel.revalidate();
		});
		//return button;
	}
	
	
}
