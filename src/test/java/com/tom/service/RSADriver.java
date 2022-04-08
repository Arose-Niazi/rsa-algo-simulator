package com.tom.service;

import java.math.BigInteger;

public class RSADriver {
	public static void main(String[] args) {

		RSA rsa = new RSA(new BigInteger("137"), new BigInteger("2879"));
		String s = "Hi";
		try {
			String cipher = new String(RSA.encrypt(s, rsa.getPublicKey()));
			System.out.println("Hi =" + cipher);
			String decrpyt = rsa.decrpyt(cipher.getBytes());
			System.out.println("Hi =" + decrpyt);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
