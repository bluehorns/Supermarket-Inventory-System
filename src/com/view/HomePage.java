package com.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage {
	private JPanel homePagePanel;
	private String username;
	
	public HomePage(String username) {
		this.username = username;
		intializePage();
		
	}
	private void intializePage() {
		homePagePanel = new JPanel();
		homePagePanel.add(new JLabel(username));
	}
	
	public JPanel getPage() {
		return homePagePanel;
	}
}
