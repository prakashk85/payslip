package com.au.prakash.tax;

import static org.junit.Assert.*;

import org.junit.Test;

import com.au.prakash.tax.service.util.SuperAmountCalculator;

public class SuperCalculatorTest {

	@Test
	public void test() {
		int gross = 5004;
		double superRate = 9;
		int superAmt = SuperAmountCalculator.calc(gross, superRate);
		assertEquals((int) Math.round(gross * superRate / 100), superAmt);
	}

}
