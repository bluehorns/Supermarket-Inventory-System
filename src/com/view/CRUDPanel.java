package com.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CRUDPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8277782146694660721L;
	private JPanel basePanel;
	private JPanel submitButtonPanel;
	private JPanel backButtonPanel;
	private JPanel buttonCRUDPanel;
	private JPanel operationPanel;
	
	private JButton backButton;
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton submitButton;
	
	public CRUDPanel() {
		intializePanel();
		basePanel();
		buttonEvents();
	}
	
	private void intializePanel() {
		this.setLayout(new BorderLayout());
		basePanel = new JPanel();
		basePanel.setLayout(new BoxLayout(basePanel,BoxLayout.LINE_AXIS));
		this.add(basePanel,BorderLayout.CENTER);
	}
	
	private void basePanel() {
		basePanel.add(setUpBackButtonPanel());
		
		basePanel.add(setUpCRUDButtonPanel());
		
		basePanel.add(setUpSubmitButtonPanel());
	}
	
	private JPanel setUpBackButtonPanel() {
		backButtonPanel = new JPanel();
		backButton = new JButton("Back");
		backButtonPanel.add(backButton);
		//backButtonPanel.setVisible(false);
		backButton.setVisible(false);
		return backButtonPanel;
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
	
	private JPanel setUpSubmitButtonPanel() {
		submitButtonPanel = new JPanel();
		submitButton = new JButton("Submit");
		submitButtonPanel.add(submitButton);
		return submitButtonPanel;
	}
	
	private void toggleButtonVisibility(Component component) {
		if(component.isVisible()){
			component.setVisible(false);
		} else {
			component.setVisible(true);
		}
		return;
	}
	
	private void buttonEvents() {
		addButton.addActionListener(_-> toggleButtonVisibility(backButton));
	}
}
