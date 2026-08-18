package com.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

	

public class AppLauncher {
	private JFrame appLauncherFrame;
	private JPanel appLauncherPanel;
	private JPanel launcherBG;
//	private JPanel landingPanel;
//	private JButton loginButton;
//	private JButton registerButton;
//	private LoginPage loginPage;
//	private RegisterPage registerPage;
	private GridBagLayout appLauncherGridBagLayout;
	
	public AppLauncher() {
		createGui();
		setUpPanel();
		showGui();
	}
	
	private void createGui() {
		appLauncherFrame = new JFrame();
		appLauncherPanel = new JPanel();
		
		appLauncherGridBagLayout = new GridBagLayout();
		appLauncherPanel.setLayout(appLauncherGridBagLayout);
		appLauncherFrame.add(appLauncherPanel);
		appLauncherFrame.setPreferredSize(new Dimension(900,450));
		appLauncherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void showGui() {
		appLauncherFrame.pack();
		appLauncherFrame.setLocationRelativeTo(null);
		appLauncherFrame.setVisible(true);
	}
	
	public void setUpPanel() {
		appLauncherPanel.setBackground(Color.green);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0.8;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		launcherBG = new JPanel();
		launcherBG.setOpaque(false);
		appLauncherPanel.add(launcherBG,gbc);
		
		
		gbc.weightx = 0.2;
		gbc.weighty = 1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		LoginPage login = new LoginPage();
		appLauncherPanel.add(login.getLoginPage(),gbc);
		
	}
	

}
