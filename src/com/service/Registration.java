package com.service;

import com.model.Employee;
import com.model.User_Account;
import com.model.User_Info;

public class Registration {
	private int userId;
	
	
//	public void registerAccount(User_Account account, User_Info info) {
//		int userId = createUserInfo(info);
//		createUserAccount(account);
//			
//	}
	
	public void registerUserInfo(User_Info info) {
		UserDBService infoDB = new UserDBService();
		infoDB.addRecord(info);
		userId = infoDB.getUserId();
	}
	
	public void registerUserAccount(String username,char[] password) {
		User_Account account = new User_Account();
		User_AccountDBService accountDB = new User_AccountDBService();
		PasswordEncryption encrypt = new PasswordEncryption();
		account.setUsername(username);
		account.setUserid(userId);
		byte[] salt = encrypt.generateSalt();
		account.setSalt(salt);
		account.setPasswordHash(encrypt.passwordHashing(password, salt));
		accountDB.addRecord(account);
	}
	
	
}
