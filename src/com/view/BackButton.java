package com.view;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BackButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3713995604224135337L;

	public BackButton() {
		setUpButton();
	}
	
	private void setUpButton() {
		this.setText("Back");
	}
	
	public void backButtonEvent(JPanel oldPage, JPanel currentPage) {
		this.addActionListener(_->{
			clearAllActionListeners();
			Container parentPanel = currentPage.getParent();
			parentPanel.remove(currentPage);
			parentPanel.add(oldPage);
			parentPanel.revalidate();
			parentPanel.repaint();
		});
		
	}
	
	private void clearAllActionListeners() {
		
		for(ActionListener x:this.getActionListeners()) {
			this.removeActionListener(x);
		}
	}
}
