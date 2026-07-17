package com.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AppLauncher {
	JFrame appLauncherFrame;
	JPanel appLauncherPanel;
	
	
	
	public AppLauncher() {
		createAndShowGui();
		addLoginPage();
		
	}
	
	private void createAndShowGui() {
		appLauncherFrame = new JFrame();
		appLauncherPanel = new JPanel();
		appLauncherPanel.setPreferredSize(new Dimension(600,450));
		appLauncherFrame.add(appLauncherPanel);
		appLauncherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appLauncherFrame.setVisible(true);
		appLauncherFrame.pack();
		appLauncherFrame.setLocationRelativeTo(null);
		
	}
	
	private void addLoginPage() {
		LoginPage p = new LoginPage();
		appLauncherPanel = p.retrieveLoginPage();
		appLauncherFrame.add(appLauncherPanel);
		
	}
}
