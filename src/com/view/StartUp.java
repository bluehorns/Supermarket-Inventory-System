package com.view;



import javax.swing.SwingUtilities;



public class StartUp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AppLauncher app = new AppLauncher();
				
			}
		});
	}
}
