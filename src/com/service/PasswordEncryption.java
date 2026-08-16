package com.service;
	
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordEncryption {
	
	private PBEKeySpec spec;
	private SecretKeyFactory factory;
	private byte[] hash;
	
	
	public byte[] passwordHashing(char[] password,byte[] passwordSalt) {
		spec = new PBEKeySpec(password,passwordSalt,65536,128);
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			hash = factory.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return hash;
	}
	
	public byte[] generateSalt() {
		 SecureRandom random = new SecureRandom();
		 byte salt[] = new byte[20];
		 random.nextBytes(salt);
		 return salt;
	}
	
	
			
	
}
