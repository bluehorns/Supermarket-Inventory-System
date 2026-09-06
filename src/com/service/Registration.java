package com.service;


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
		DBServiceUser_Info infoDB = new DBServiceUser_Info();
		infoDB.addRecord(info);
		userId = infoDB.getUserId();
	}
	
	public void registerUserAccount(String username,char[] password) {
		User_Account account = new User_Account();
		DBServiceUser_Account accountDB = new DBServiceUser_Account();
		PasswordEncryption encrypt = new PasswordEncryption();
		account.setUsername(username);
		account.setUserid(userId);
		byte[] salt = encrypt.generateSalt();
		account.setSalt(salt);
		account.setPasswordHash(encrypt.passwordHashing(password, salt));
		accountDB.addRecord(account);
	}
	
	
}
