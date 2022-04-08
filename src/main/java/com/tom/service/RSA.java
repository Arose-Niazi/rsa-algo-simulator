package com.tom.service;

import java.math.BigInteger;

public class RSA {

	private final BigInteger n;
	private final BigInteger phiN;

	private BigInteger e;

	private BigInteger[] publicKey;
	private BigInteger privateKey;

	public RSA(BigInteger p, BigInteger q) {
		n = p.multiply(q);
		phiN = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		generatePublicKey();
		generatePrivateKey();

		System.out.println("p = " + p);
		System.out.println("q = " + q);
		System.out.println("n = " + publicKey[0]);
		System.out.println("phiN = " + phiN);

		System.out.println("publicKey = " + publicKey[1]);

		System.out.println("privateKey = " + privateKey);
	}

	private void generatePublicKey() {
		generateE();
		publicKey = new BigInteger[] { n, e };
	}

	private void generatePrivateKey() {
		// privateKey = BigInteger.ONE.add(phiN.multiply(BigInteger.TWO)).divide(e);
		privateKey = e.modInverse(phiN);
	}

	private void generateE() {
		int e = 2;
		while (e < phiN.intValue()) {
			if (CustomMath.gcd(e, phiN.intValue()) == 1)
				break;
			else
				e++;
		}
		this.e = new BigInteger(new String(e + ""));
	}

	public BigInteger[] getPublicKey() {
		return this.publicKey;
	}

	public static byte[] encrypt(String data, BigInteger[] publicKey) throws Exception {
		BigInteger cipher = new BigInteger(data.getBytes());
		if (cipher.compareTo(publicKey[0]) == 1) {
			throw new Exception("Please select bigger primer numbers, not possible to compute this string");
		}
		cipher = cipher.modPow(publicKey[1], publicKey[0]);
		return cipher.toByteArray();
	}

	public String decrpyt(byte[] cipher) {
		BigInteger message = new BigInteger(cipher);
		message = message.modPow(privateKey, n);
		return new String(message.toByteArray());
	}

}
