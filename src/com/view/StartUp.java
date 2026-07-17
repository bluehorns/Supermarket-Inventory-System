package com.view;

import javax.swing.SwingUtilities;

public class StartUp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//LoginPage log = new LoginPage();
				//ProductPage pp = new ProductPage();
				HomePage home = new HomePage();
				//AppLauncher app = new AppLauncher();
			}
		});
	}
}
