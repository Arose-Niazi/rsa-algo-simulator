package com;

public class CustomMath {

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static boolean checkPrime(int a) {
		boolean flag = false;
		for (int i = 2; i <= a / 2; ++i) {

			if (a % i == 0) {
				flag = true;
				break;
			}
		}

		if (!flag)
			return true;
		else
			return false;

	}

}
