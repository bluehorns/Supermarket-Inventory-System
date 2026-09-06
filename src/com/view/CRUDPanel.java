package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.service.DBServiceEmployee;
import com.view.form.EmployeeForm;
import com.view.form.Form;


public class CRUDPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8277782146694660721L;
	private JPanel basePanel;
	private JPanel buttonCRUDPanel;
	private JPanel backButtonPanel;
	private JPanel formPanel;
	
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	
	private BackButton backButton;
	private ButtonSubmitAbstract submitButton;
	
	public CRUDPanel() {
		intializePanel();
		setBasePanel();
		colourTest();
	}
	
	private void colourTest() {
		buttonCRUDPanel.setBackground(Color.magenta);
	}
	
	private void intializePanel() {
		this.setLayout(new BorderLayout());
		basePanel = new JPanel();
		basePanel.setLayout(new BorderLayout());
		this.add(basePanel,BorderLayout.CENTER);
	}
	

	private void setBasePanel() {
		backButton =  new BackButton();
		backButtonPanel = new JPanel();
		backButtonPanel.add(backButton);
		basePanel.add(backButtonPanel,BorderLayout.WEST);
		basePanel.add(setUpCRUDButtonPanel(),BorderLayout.CENTER);
	}
	
	private JPanel setFormPanel(JPanel form, JButton button) {
		formPanel = new JPanel();
		formPanel.setLayout(new BorderLayout());
		
		formPanel.add(form,BorderLayout.CENTER);
		formPanel.add(button,BorderLayout.EAST);
		
		return formPanel;
		}
	
	private JPanel setUpCRUDButtonPanel() {
		buttonCRUDPanel = new JPanel();
		
		addButton = new JButton("Add");
		buttonCRUDPanel.add(addButton);
		
		editButton = new JButton("Edit");
		buttonCRUDPanel.add(editButton);
		
		deleteButton = new JButton("Delete");
		buttonCRUDPanel.add(deleteButton);
		
		return buttonCRUDPanel;
	}
	
	
	public void addButtonEvent(Form form) {
		addButton.addActionListener(_-> {
			submitButton = new ButtonAdd().buttonEvent(form.getService(), form);
			System.out.println(submitButton);
			basePanel.remove(buttonCRUDPanel);
			basePanel.add(setFormPanel(form.getPanel(),submitButton));
			backButton.backButtonEvent(buttonCRUDPanel, formPanel);
			this.revalidate();
			this.repaint();
		});
	}
	
//	public void editButtonPanel(JPanel newPanel) {
//		
//		editButton.addActionListener(_->{
//			basePanel.remove(buttonCRUDPanel);
//			basePanel.add(testPanel);
//			backButton.backButtonEvent(buttonCRUDPanel, formPanel);
//			this.revalidate();
//			this.repaint();
//		});
//	}
	
	
}
