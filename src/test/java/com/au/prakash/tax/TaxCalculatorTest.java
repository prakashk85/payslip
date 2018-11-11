package com.au.prakash.tax;

import static org.junit.Assert.*;

import org.junit.Test;

import com.au.prakash.tax.service.util.TaxAmountCalculator;

public class TaxCalculatorTest {

	@Test
	public void test1() {
		int gross = 60050;
		assertEquals(922, TaxAmountCalculator.calc(gross));
	}
	
	@Test
	public void test2() {
		int gross = 120000;
		assertEquals(2669, TaxAmountCalculator.calc(gross));
	}

}
