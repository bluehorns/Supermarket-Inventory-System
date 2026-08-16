package com.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class AppLauncher {
	JFrame appLauncherFrame;
	JPanel appLauncherPanel;
	JPanel landingPanel;
	JButton loginButton;
	JButton registerButton;
	
	CardLayout appLauncherCardLayout;
	
	public AppLauncher() {
		createAndShowGui();
		addCards();
	}
	
	private void createAndShowGui() {
		appLauncherFrame = new JFrame();
		appLauncherPanel = new JPanel();
		
		appLauncherCardLayout = new CardLayout();
		appLauncherPanel.setLayout(appLauncherCardLayout);
		
		appLauncherPanel.setPreferredSize(new Dimension(600,450));
		appLauncherFrame.add(appLauncherPanel,BorderLayout.CENTER);
		appLauncherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appLauncherFrame.setVisible(true);
		appLauncherFrame.pack();
		appLauncherFrame.setLocationRelativeTo(null);
		
	}
	
	private void addCards() {
		setUpLandingPanel();
		appLauncherPanel.add(landingPanel,"landing");
		
		LoginPage loginPage = new LoginPage();
		appLauncherPanel.add(loginPage.getLoginPage(),"login");
		loginPage.setBackButtonEvent((e) -> appLauncherCardLayout.show(appLauncherPanel, "landing"));
		
		RegisterPage registerPage = new RegisterPage();
		appLauncherPanel.add(registerPage.getRegisterPage(),"register");
		registerPage.setBackButton(e-> appLauncherCardLayout.show(appLauncherPanel,"landing"));
	}
	
	public void setUpLandingPanel() {
		landingPanel = new JPanel();
		//landingPanel.setLayout(new BorderLayout());
		loginButton = new JButton("Login");
		landingPanel.add(loginButton);
		loginButton.addActionListener(e -> appLauncherCardLayout.show(appLauncherPanel, "login"));
		
		registerButton = new JButton("Register");
		landingPanel.add(registerButton);
		registerButton.addActionListener(e -> appLauncherCardLayout.show(appLauncherPanel, "register"));
		
	}
	
	public void setUpBackButton() {
		
	}

	

}
