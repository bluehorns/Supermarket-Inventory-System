package com.service;

import java.util.Arrays;

import com.model.User_Account;

public class LoginValidation {
	private int userId;
	
	 public boolean validateLogin(String username,char[] password) {
		DBServiceUser_Account accountService = new DBServiceUser_Account();
		PasswordEncryption encrypt = new PasswordEncryption();
		User_Account account = accountService.fetchRecord(username);
		byte[] storedSalt = account.getSalt();
		byte[] passwordHash = encrypt.passwordHashing(password,storedSalt);
		byte[] storedPasswordHash = account.getPasswordHash();
		if(Arrays.equals(passwordHash, storedPasswordHash)) {
			userId = account.getUserid();
			return true;
		}
		return false;
	}
	
	public int getUserId() {
		return userId;
	}
	
}
