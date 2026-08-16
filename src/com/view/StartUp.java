package com.view;



import javax.swing.SwingUtilities;

public class StartUp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//LoginPage log = new LoginPage();
				//ProductPage pp = new ProductPage();
				//BasePage home = new BasePage();
				
//				PasswordEncryption pass = new PasswordEncryption();
//				byte[] salt = pass.generateSalt();
//				byte[] passwordHash = pass.passwordHashing("banana".toCharArray(), salt);
//				User_Account acc = new User_Account();
//				acc.setUserid(1);
//				acc.setUsername("hello");
//				acc.setPasswordHash(passwordHash);
//				acc.setSalt(salt);
//				User_AccountDBService db = new User_AccountDBService();
//				db.addRecord(acc);
				
				AppLauncher app = new AppLauncher();
			
				
				
				
			}
		});
	}
}
