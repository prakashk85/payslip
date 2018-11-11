package com.au.prakash.tax.bean;

public class PaySlipResponse {
	private String name;
	private String paymentStartDate;
	private int grossSalary;
	private int incomeTax;
	private int netSalary;
	private int superAmount;

	public PaySlipResponse(String firstName, String lastName, String paymentStartDate) {
		this.name = firstName + " " + lastName;
		this.paymentStartDate = paymentStartDate;
	}

	public PaySlipResponse(String firstName, String lastName, String paymentStartDate, int gross, int tax, int net,
			int superAmt) {
		this.name = firstName + " " + lastName;
		this.paymentStartDate = paymentStartDate;
		this.grossSalary = gross;
		this.incomeTax = tax;
		this.netSalary = net;
		this.superAmount = superAmt;
	}

	public String getPaymentStartDate() {
		return paymentStartDate;
	}

	public String getName() {
		return name;
	}

	public int getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(int grossSalary) {
		this.grossSalary = grossSalary;
	}

	public int getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(int incomeTax) {
		this.incomeTax = incomeTax;
	}

	public int getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(int netSalary) {
		this.netSalary = netSalary;
	}

	public int getSuperAmount() {
		return superAmount;
	}

	public void setSuperAmount(int superAmount) {
		this.superAmount = superAmount;
	}
}
