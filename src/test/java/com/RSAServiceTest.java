package com;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

import java.math.BigInteger;

import org.hamcrest.MatcherAssert;

public class RSAServiceTest {
	private RSA rsa;

	@Before
	public void setUp() {
		rsa = new RSA(new BigInteger("137"), new BigInteger("2879"));
	}

	@Test
	public void publicKeyCheck() {
		BigInteger[] result = rsa.getPublicKey();

		MatcherAssert.assertThat(result[0].intValue(), equalTo(394423));
		MatcherAssert.assertThat(result[1].intValue(), equalTo(3));
	}

	@Test
	public void encrypt() throws Exception {
		String result = new String(RSA.encrypt("3", rsa.getPublicKey()));

		MatcherAssert.assertThat(result, equalTo("+"));
	}

	@Test
	public void decrpyt() throws Exception {
		String result = rsa.decrpyt(RSA.encrypt("Hi", rsa.getPublicKey()));

		MatcherAssert.assertThat(result, equalTo("Hi"));
	}
}
