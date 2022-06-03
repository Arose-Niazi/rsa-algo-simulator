package com;

import java.math.BigInteger;
import java.util.Scanner;

public class RSADriver {
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter a prime number: ");
			int number1 = input.nextInt();
			if (!CustomMath.checkPrime(number1)) {
				System.err.println("Please enter prime number only.");
				input.close();
				return;
			}
			System.out.print("Enter another prime number: ");
			int number2 = input.nextInt();
			if (!CustomMath.checkPrime(number2)) {
				System.err.println("Please enter prime number only.");
				input.close();
				return;
			}
			// RSA rsa = new RSA(new BigInteger("137"), new BigInteger("2879"));
			RSA rsa = new RSA(new BigInteger(number1 + ""), new BigInteger(number2 + ""));

			System.out.println("Enter data to cipher: ");
			String s = input.nextLine();
			s = input.nextLine();
			input.close();

			String cipher = new String(RSA.encrypt(s, rsa.getPublicKey()));
			System.out.println("Cipher: " + cipher);
			String decrpyt = rsa.decrpyt(cipher.getBytes());
			System.out.println("Decrypted: " + decrpyt);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
