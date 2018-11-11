package com.au.prakash.tax.bean;

/*
 * Object to hold tax limit details
 * 
 * */
public class TaxSlab {

	private final int minAmt;
	private final int maxAmt;
	private final int baseAmt;
	private final double rate;

	public TaxSlab(int minAmt, int maxAmt, int baseAmt, double rate) {
		super();
		this.minAmt = minAmt;
		this.maxAmt = maxAmt;
		this.baseAmt = baseAmt;
		this.rate = rate;
	}

	public int getMinAmt() {
		return minAmt;
	}

	public int getMaxAmt() {
		return maxAmt;
	}

	public int getBaseAmt() {
		return baseAmt;
	}

	public double getRate() {
		return rate;
	}
}
