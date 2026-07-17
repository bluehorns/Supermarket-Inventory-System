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

public class HomePage {
	JFrame HomePageFrame;
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
	
	public HomePage() {
		
		initialiseFrame();
	}
	
	public void initialiseFrame() {
		HomePageFrame = new JFrame();	
		//HomePageFrame.setUndecorated(true);  //set undecorated before set visible or error comes
		HomePageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		HomePageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HomePageFrame.setVisible(true);
		HomePageFrame.setLayout(new GridBagLayout());
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
		HomePageFrame.add(buttonPanel,gbc);
		
		cardPanel = new JPanel();
		gbc.gridy = 1;
		gbc.weighty = 0.9;
		cardPanel.setBackground(Color.GREEN);
		HomePageFrame.add(cardPanel,gbc);
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
		buttonPanel.add(transactionButton);
		
		
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
		
		transactionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardPanel.getLayout()).show(cardPanel, "transaction");
				
			}
		});
		
	}
	
	
	 public void addCardsToPanel() {
		homePageCard = new JPanel();
		homePageCard.setBackground(Color.black);
		
		billPageCard = new JPanel();
		employeePageCard = new JPanel();
		
		ProductPage  p = new ProductPage();
		productPageCard = p.retrievePagePane();

		
		transactionPageCard = new JPanel();
		salesPageCard = new JPanel();
		
		
		cardPanel.add(homePageCard,"home");
		cardPanel.add(billPageCard,"bill");
		cardPanel.add(employeePageCard,"employee");
		cardPanel.add(productPageCard,"product");
		cardPanel.add(transactionPageCard,"transaction");
		cardPanel.add(salesPageCard,"sales");
	}
	 
	 
	 
	 
}

