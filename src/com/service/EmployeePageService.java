package com.service;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.view.EmployeeForm;

public class EmployeePageService {
	
	public static void operationButtonEvent(JButton button,JButton backButton, JPanel panel) {
		button.addActionListener(_ ->{
			backButton.setVisible(true);
			panel.removeAll();
			panel.add(new EmployeeForm(button.getText()).getPanel());
			panel.revalidate();
			System.out.println("test");
		});
		//return operation;
	}
	
	public static void backButtonEvent(JButton button,JPanel operationPanel, JPanel backPanel) {
		button.addActionListener(_ ->{
			button.setVisible(false);
			operationPanel.removeAll();
			operationPanel.add(backPanel);
			operationPanel.revalidate();
		});
		//return button;
	}
	
	
}
