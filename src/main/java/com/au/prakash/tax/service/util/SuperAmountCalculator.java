package com.au.prakash.tax.service.util;

public final class SuperAmountCalculator {

	private SuperAmountCalculator() {
		// do nothing
	}

	/*
	 * Calculates Superannuation ammount for the given annual salary based on
	 * super percentage
	 */
	public static int calc(int gross, double superRate) {
		return (int) Math.round(gross * superRate / 100);
	}

}
