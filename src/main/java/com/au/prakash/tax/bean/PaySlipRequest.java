package com.au.prakash.tax.bean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PaySlipRequest {

	@Size(min = 3, max = 20, message = "First Name must be between 3 and 20 characters")
	private String firstName;

	@Size(min = 3, max = 20, message = "Last Name must be between 3 and 20 characters")
	private String lastName;

	@Positive(message = "Annual Salary must be greater than 0")
	private int annualSalary;

	@Positive(message = "Super Rate must be greater than 0")
	@Digits(integer = 2, fraction = 2, message = "Super Rate must have maximum of 2 digits and 2 fractions")
	private double superRate;

	@NotBlank(message = "Payment start date must not be blank")
	private String paymentStartDate;

	public PaySlipRequest() {
		// do nothing
	}

	public PaySlipRequest(String firstName, String lastName, int annualSalary, double superRate,
			String paymentStartDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = annualSalary;
		this.superRate = superRate;
		this.paymentStartDate = paymentStartDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}

	public double getSuperRate() {
		return superRate;
	}

	public void setSuperRate(double superRate) {
		this.superRate = superRate;
	}

	public String getPaymentStartDate() {
		return paymentStartDate;
	}

	public void setPaymentStartDate(String paymentStartDate) {
		this.paymentStartDate = paymentStartDate;
	}
}