package com.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasePage {
	JFrame BasePageFrame;
	GridBagConstraints gbc;

	JPanel buttonPanel;
	JButton homeButton;
	JButton billButton;
	JButton employeeButton;
	JButton productButton;
	JButton salesButton;
	JButton transactionButton;
	
	JPanel cardPanel;
	JPanel homePageCard;
	JPanel billPageCard;
	JPanel employeePageCard;
	JPanel productPageCard;
	JPanel transactionPageCard;
	JPanel salesPageCard;
	
	public BasePage(int userId) {
		initialiseFrame();
	}
	
	public void initialiseFrame() {
		BasePageFrame = new JFrame();	
		//HomePageFrame.setUndecorated(true);  //set undecorated before set visible or error comes
		BasePageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		BasePageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BasePageFrame.setVisible(true);
		BasePageFrame.setLayout(new GridBagLayout());
		intialisePane();
		
	}
	public void intialisePane() {
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLUE);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 0.08;
		BasePageFrame.add(buttonPanel,gbc);
		
		cardPanel = new JPanel();
		gbc.gridy = 1;
		gbc.weighty = 0.9;
		BasePageFrame.add(cardPanel,gbc);
		cardPanel.setLayout(new CardLayout());
		
		addNavigationButtons();
		addCardsToPanel();
		buttonNavigation();
	}
	
	
	public void addNavigationButtons() {
		homeButton = new JButton("Home");
		billButton = new JButton("Bill");
		employeeButton = new JButton("Employee");
		productButton = new JButton("Products");
		salesButton = new JButton("Sales");
		transactionButton = new JButton("Transaction");
		
		buttonPanel.add(homeButton);
		buttonPanel.add(billButton);
		buttonPanel.add(employeeButton);
		buttonPanel.add(productButton);
		buttonPanel.add(salesButton);
		
		
	}
	
	
	public void buttonNavigation() {
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//c1.show(cardPanel,"home");
				// Source - https://stackoverflow.com/a/34280207
				// Posted by Bahramdun Adil
				// Retrieved 2026-05-31, License - CC BY-SA 3.0
				((CardLayout) cardPanel.getLayout()).show(cardPanel, "home");

			}
		});
		
		billButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardPanel.getLayout()).show(cardPanel, "bill");
				
			}
		});
		
		employeeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardPanel.getLayout()).show(cardPanel, "employee");
				
			}
		});
		
		productButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardPanel.getLayout()).show(cardPanel, "product");
				
			}
		});
		
		salesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardPanel.getLayout()).show(cardPanel, "sales");
				
			}
		});
		
	}
	
	
	 public void addCardsToPanel() {
		HomePage homePage = new HomePage();
		homePageCard = homePage.getPage();

		
		BillPage billPage = new BillPage();
		billPageCard = billPage.getPage();
		
		EmployeePage employeePage = new EmployeePage();
		employeePageCard = employeePage.getPage();
		
		ProductPage  productPage = new ProductPage();
		productPageCard = productPage.retrievePagePane();
		
		
		
		SalesPage salesPage = new SalesPage();
		salesPageCard = salesPage.getPage();
		
		
		cardPanel.add(homePageCard,"home");
		cardPanel.add(billPageCard,"bill");
		cardPanel.add(employeePageCard,"employee");
		cardPanel.add(productPageCard,"product");
		cardPanel.add(salesPageCard,"sales");
	}
	 
	 
	 
	 
}

