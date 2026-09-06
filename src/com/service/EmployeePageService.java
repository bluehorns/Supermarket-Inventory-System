package com.service;


import java.awt.BorderLayout;	

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import com.view.form.EmployeeForm;
	
public class EmployeePageService {
	
	public static void selectOperationButtonEvent(EmployeeForm employeeForm,JButton button,JButton backButton, JPanel operationPanel) {
		button.addActionListener(_ ->{
			backButton.setVisible(true);
			operationPanel.removeAll();
			operationPanel.add(employeeForm.getPanel(),BorderLayout.CENTER);
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
	
	
	public static void submitFormButtonEvent(JButton button,EmployeeForm form) {
		button.addActionListener(_ ->{
			SwingWorker<Void,Void> worker = new SwingWorker<>() {
				@Override
				protected Void doInBackground() throws Exception {
					DBServiceEmployee dbservice = new DBServiceEmployee();
					//dbservice.addRecord(form.readForm());
					return null;
				}
				@Override
				protected void done() {
					// TODO Auto-generated method stub
					super.done();
				}
				
			};
			worker.execute();
		});
	}
	
}
