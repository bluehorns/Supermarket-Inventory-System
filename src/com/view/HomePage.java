package com.view;

import javax.swing.JPanel;

public class HomePage {
	private JPanel homePagePanel;
	
	
	public HomePage() {
		intializePage();
	}
	private void intializePage() {
		homePagePanel = new JPanel();
		
	}
	
	public JPanel getPage() {
		return homePagePanel;
	}
}
